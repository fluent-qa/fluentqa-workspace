package io.fluentqa.qtm.api.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import io.fluent.builtin.CollectionsUtils;
import io.fluentqa.qtm.api.model.*;
import io.fluentqa.qtm.api.repo.ApiMonitorRecordRepo;
import io.fluentqa.qtm.api.repo.ApiTestStepRepo;
import io.fluentqa.qtm.api.repo.RawApiTestCaseRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@Service
public class ApiTestCaseService {
    private final String DEFAULT_EXPECTED = "{ \"status_code\":200,\"values\":{}\n" +
            "}";
    @Resource
    RawApiTestCaseRepo rawApiTestCaseRepo;

    @Resource
    ApiMonitorRecordRepo apiMonitorRecordRepo;

    @Resource
    ApiTestStepRepo apiTestStepRepo;


    /**
     * @param services: HTTP API Services
     *                  1. Merge All HttpAPI Services if method,service and request-body/input is same
     */
    public void convertToRawTestCase(List<RemoteApi> services) {
        List<RawApiTestCase> cases = new ArrayList<>();
        services.forEach(service -> {
            RawApiTestCase apiCase = new RawApiTestCase();
            BeanUtils.copyProperties(service, apiCase);
            apiCase.setUri(service.getEndpoint());
            apiCase.setExpected(DEFAULT_EXPECTED);
            //get body
            String path = service.getEndpoint().replaceAll("https://\\{\\{base_url\\}\\}", "");
            List<ApiMonitorRecord> result = apiMonitorRecordRepo.findApiMonitorRecordByPath(path);
            if (!result.isEmpty()) {
                apiCase.setInput(result.get(0).getRequestBody());
            } else {
                apiCase.setInput(service.getBody());
            }
            cases.add(apiCase);
        });
        rawApiTestCaseRepo.saveAll(cases);
    }

    /**
     * @param records Http traffic
     *                1. Merge All HttpAPI Services if method,service and request-body/input is same
     */
    public void convertApiMonitorRecordToTestCase(List<ApiMonitorRecord> records) {
        List<RawApiTestCase> cases = new ArrayList<>();
        List<ApiMonitorRecord> result = CollectionsUtils.filterToReduceRedundant(
                records, new Function<ApiMonitorRecord, String>() {
                    @Override
                    public String apply(ApiMonitorRecord apiMonitorRecord) {
                        return StrUtil.join(
                                "-", apiMonitorRecord.getApi(), apiMonitorRecord.getApp(),
                                apiMonitorRecord.getService(), apiMonitorRecord.getPath(),
                                apiMonitorRecord.getMethod(), apiMonitorRecord.getRequestBody()
                        );
                    }
                }
        );
        result.forEach(service -> {
            RawApiTestCase apiCase = new RawApiTestCase();
            BeanUtils.copyProperties(service, apiCase);
            apiCase.setUri(service.getPath());
            apiCase.setExpected(DEFAULT_EXPECTED);
            apiCase.setServiceMethod(service.getMethod());
            apiCase.setServiceName(service.getService());
            apiCase.setName(service.getService());
            apiCase.setServiceMethod(service.getApi());
            //get body
            apiCase.setInput(service.getRequestBody());
            apiCase.setScenario(service.getRecordName());
            cases.add(apiCase);
        });
        rawApiTestCaseRepo.saveAll(cases);
    }

    /**
     * Only Passed Test Scenario could be converted into test steps
     *
     * @param data
     */
    public void convertApiTestResultToApiTestStep(List<ApiTestRecord> data) {
        List<ApiStep> apiTestSteps = new ArrayList<>();
        data.forEach((apiTestRecord) -> {
            if (apiTestRecord.isSuccess()) {
                apiTestSteps.add(BeanUtil.copyProperties(apiTestRecord, ApiStep.class));
            } else {
                throw new RuntimeException("some cases are failed, can't convert to api test step");
            }
        });
        apiTestStepRepo.saveAll(apiTestSteps);
    }
}
