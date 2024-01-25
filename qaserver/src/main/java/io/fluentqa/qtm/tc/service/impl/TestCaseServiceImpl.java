package io.fluentqa.qtm.tc.service.impl;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.StrUtil;
import io.fluentqa.base.proxies.AuditDataEnhancerProxy;
import io.fluentqa.qtm.pm.product.model.ProductModuleModel;
import io.fluentqa.qtm.pm.product.service.ProductModuleService;
import io.fluentqa.qtm.tc.dto.TestCaseDTO;
import io.fluentqa.qtm.tc.model.TestCase;
import io.fluentqa.qtm.tc.repo.TestCaseRepo;
import io.fluentqa.qtm.tc.service.TestCaseService;
import org.apache.commons.math3.stat.descriptive.summary.Product;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import xyz.erupt.upms.service.EruptUserService;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class TestCaseServiceImpl  implements TestCaseService {
    @Resource
    private TestCaseRepo testCaseRepo;
    @Resource
    private ProductModuleService productMetaService;

    @Resource
    private AuditDataEnhancerProxy dataEnhancerProxy;
    @Override
    @Transactional
    @Async
    /**
     * notice:parent Product can't be created,parent product must be configured
     * 1. 如果UUID没有或者找不到，则新增测试用例
     * 2. 新增测试用例中，
     */
    public void saveTestCases(List<TestCaseDTO> cases,
                              ProductModuleModel parentProduct,
                              ProductModuleModel module,String updater) {
        for (TestCaseDTO aCase : cases) {
            TestCase tcEntity = createOrUseExistingTestCase(aCase);
            ProductModuleModel rootProduct = getRootProductMeta(aCase);
            ProductModuleModel parentModule = productMetaService.createModuleIfNotExist(rootProduct.getId(),
                    aCase.getModuleName(),updater);
            ProductModuleModel subModule = whichSubModule(parentModule, aCase,updater);
            tcEntity.setModule(subModule);
            tcEntity.setProduct(rootProduct);
            tcEntity.setParent(parentModule);
            if (StrUtil.isBlankIfStr(aCase.getPriority())) {
                tcEntity.setPriority("P2");
            }
            tcEntity.setSteps(StrUtil.join(":\n", aCase.getFeature(),
                    aCase.getSummary(), aCase.getSteps()));

            testCaseRepo.save(tcEntity);
        }
    }

    private TestCase createOrUseExistingTestCase(TestCaseDTO aCase) {
        TestCase tcEntity;
        if (StrUtil.isBlank(aCase.getUuid())) {
            tcEntity = BeanUtil.copyProperties(aCase, TestCase.class);
            tcEntity.setUuid(UUID.fastUUID().toString(true));

        } else {
            tcEntity = testCaseRepo.findByUuid(aCase.getUuid());
            if (tcEntity == null) {
                tcEntity = BeanUtil.copyProperties(aCase, TestCase.class); //生成新的的UUID
            } else {
                BeanUtil.copyProperties(aCase, tcEntity, "id"); //更新数据库数据
            }
        }
        return tcEntity;
    }


    private ProductModuleModel getRootProductMeta(TestCaseDTO aCase) {
        ProductModuleModel rootProductMeta = productMetaService.findByName(aCase.getProductName());
        if (rootProductMeta == null) {
            throw new RuntimeException("找不到产品");
        }
        return rootProductMeta;
    }


    private ProductModuleModel whichSubModule(ProductModuleModel parentProduct, TestCaseDTO aCase,String updater) {
        if (parentProduct.getName().equalsIgnoreCase(aCase.getModuleName())) return parentProduct;
        return productMetaService.createModuleIfNotExist(parentProduct.getId(), aCase.getModuleName(),updater);

    }


}
