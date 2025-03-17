package io.fluentqa.qtm.tc.service;

import io.fluentqa.base.product.model.ProductModuleModel;
import io.fluentqa.qtm.tc.dto.TestCaseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TestCaseService {

    public void saveTestCases(List<TestCaseDTO> cases,
                              ProductModuleModel product, ProductModuleModel module,String updater);
}
