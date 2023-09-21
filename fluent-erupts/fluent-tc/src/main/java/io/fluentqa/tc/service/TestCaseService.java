package io.fluentqa.tc.service;

import io.fluentqa.pm.product.model.Product;
import io.fluentqa.tc.dto.TestCaseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TestCaseService {

    public void saveProductCases(List<TestCaseDTO> cases, Product product, Product module);
}
