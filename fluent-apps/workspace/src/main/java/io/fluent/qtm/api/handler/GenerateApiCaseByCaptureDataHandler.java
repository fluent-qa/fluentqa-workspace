package io.fluent.qtm.api.handler;

import io.fluent.qtm.api.model.ApiMonitorRecord;
import io.fluent.qtm.api.service.ApiTestCaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import xyz.erupt.annotation.fun.OperationHandler;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class GenerateApiCaseByCaptureDataHandler implements OperationHandler<ApiMonitorRecord, Void> {

    @Resource
    private ApiTestCaseService apiService;
    @Override
    public String exec(List<ApiMonitorRecord> data, Void unused, String[] param) {
        log.info("start convert api capture data");
        apiService.convertApiMonitorRecordToTestCase(data);
        return null;
    }
}
