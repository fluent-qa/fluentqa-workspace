package io.fluentqa.tc.service.impl;



import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import io.fluentqa.base.proxies.AuditDataEnhancerProxy;
import io.fluentqa.mindmap.api.MindMapAccessor;
import io.fluentqa.pm.product.model.ProductModuleModel;
import io.fluentqa.tc.dto.TestCaseDTO;
import io.fluentqa.tc.model.TestCase;
import io.fluentqa.tc.repo.TestCaseRepo;
import io.fluentqa.tc.service.TestCaseService;
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
    private TestCaseService testCaseService;

    public List<TestCaseDTO> toTestCaseModel(String xmlFilePath) {
        MindMapAccessor accessor = new MindMapAccessor();
        return accessor.readMindMapToBean(xmlFilePath, TestCaseDTO.class);
    }

    @Transactional
    public void saveTestCases(String xmlFilePath, MetaModel model) {
        List<TestCaseDTO> testCaseModels = toTestCaseModel(xmlFilePath);
        ProductModuleModel product = BeanUtil.getProperty(model, "product");
        ProductModuleModel module = BeanUtil.getProperty(model, "module");
        testCaseService.saveProductCases(testCaseModels,product,module);
    }

}
