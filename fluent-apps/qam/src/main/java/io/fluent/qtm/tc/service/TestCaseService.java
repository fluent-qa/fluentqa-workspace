package io.fluent.qtm.tc.service;

import io.fluent.base.product.model.ProductModuleModel;
import io.fluent.qtm.tc.dto.TestCaseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TestCaseService {

    public void saveTestCases(List<TestCaseDTO> cases,
                              ProductModuleModel product, ProductModuleModel module,String updater);
}
