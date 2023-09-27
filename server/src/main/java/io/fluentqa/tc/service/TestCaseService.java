package io.fluentqa.tc.service;

import io.fluentqa.pm.product.model.ProductModuleModel;
import io.fluentqa.tc.dto.TestCaseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TestCaseService {

    public void saveProductCases(List<TestCaseDTO> cases, ProductModuleModel product, ProductModuleModel module);
}
