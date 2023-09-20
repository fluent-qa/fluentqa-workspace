package io.fluentqa.tc.service.impl;



import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import io.fluentqa.erupts.base.proxies.AuditDataEnhancerProxy;
import io.fluentqa.mindmap.api.MindMapAccessor;
import io.fluentqa.pm.product.model.Product;
import io.fluentqa.tc.dto.TestCaseDTO;
import io.fluentqa.tc.model.TestCase;
import io.fluentqa.tc.repo.TestCaseRepo;
import org.springframework.stereotype.Service;
import xyz.erupt.jpa.model.MetaModel;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 1.Import MindMapping file to test case database
 * 2.export selected test cases as mindmapping file
 */
//TODO: convert to same TestCase Converter
@Service("mindMappingService")
public class MindMappingService {
    @Resource
    private TestCaseRepo testCaseRepo;
    @Resource
    private AuditDataEnhancerProxy auditDataEnhancerProxy;

    public List<TestCaseDTO> toTestCaseModel(String xmlFilePath) {
        MindMapAccessor accessor = new MindMapAccessor();
        return accessor.readMindMapToBean(xmlFilePath, TestCaseDTO.class);
    }

    @Transactional
    public void saveTestCases(String xmlFilePath, MetaModel model) {
        List<TestCaseDTO> testCaseModels = toTestCaseModel(xmlFilePath);
        Product product = BeanUtil.getProperty(model, "product");
        Product module = BeanUtil.getProperty(model, "module");

        List<TestCase> testCaseEntities = testCaseModels.stream().map(testCaseModel -> {

            TestCase tc = BeanUtil.copyProperties(testCaseModel, TestCase.class);
            tc.setProduct(product);
            tc.setModule(module);
            tc.setSteps(StrUtil.join("\n", testCaseModel.getFeature(),
                    testCaseModel.getSummary(), testCaseModel.getSteps()));
            auditDataEnhancerProxy.enhanceTimeAndUserAuditData(tc);
            return tc;
        }).collect(Collectors.toList());
        testCaseRepo.saveAll(testCaseEntities);
    }

}
