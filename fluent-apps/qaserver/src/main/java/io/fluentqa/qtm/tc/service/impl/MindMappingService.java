package io.fluentqa.qtm.tc.service.impl;



import cn.hutool.core.bean.BeanUtil;
import io.fluentqa.mindmap.api.MindMapAccessor;
import io.fluentqa.base.product.model.ProductModuleModel;
import io.fluentqa.qtm.tc.dto.TestCaseDTO;
import io.fluentqa.qtm.tc.service.TestCaseService;
import org.springframework.stereotype.Service;
import xyz.erupt.jpa.model.MetaModel;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

/**
 * 1.Import MindMapping file to test case database
 * 2.export selected test cases as mindmapping file
 */
//TODO: convert to same TestCase Converter
@Service("mindMappingService")
public class MindMappingService  {

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
        testCaseService.saveTestCases(testCaseModels,product,module,model.getUpdateBy());
    }

}
