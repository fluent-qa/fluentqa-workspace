package io.fluentqa.qtm.api.handler;

import io.fluentqa.qtm.api.model.ApiTestRecord;
import io.fluentqa.qtm.api.service.ApiTestCaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import xyz.erupt.annotation.fun.OperationHandler;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class GenerateApiTestStepByApiTestRecord implements OperationHandler<ApiTestRecord, Void> {

    @Resource
    private ApiTestCaseService apiService;
    @Override
    public String exec(List<ApiTestRecord> data, Void unused, String[] param) {
        log.info("start convert api capture data");
        apiService.convertApiTestResultToApiTestStep(data);
        return null;
    }
}
