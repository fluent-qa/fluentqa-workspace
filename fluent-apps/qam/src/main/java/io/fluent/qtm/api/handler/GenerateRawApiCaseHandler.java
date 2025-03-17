package io.fluent.qtm.api.handler;

import io.fluent.qtm.api.model.RemoteApi;
import io.fluent.qtm.api.service.ApiTestCaseService;
import org.springframework.stereotype.Service;
import xyz.erupt.annotation.fun.OperationHandler;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GenerateRawApiCaseHandler implements OperationHandler<RemoteApi, Void> {

    @Resource
    private ApiTestCaseService apiService;
    @Override
    public String exec(List<RemoteApi> data, Void unused, String[] param) {
        System.out.println("this is tests");
        apiService.convertToRawTestCase(data);
        return null;
    }
}
