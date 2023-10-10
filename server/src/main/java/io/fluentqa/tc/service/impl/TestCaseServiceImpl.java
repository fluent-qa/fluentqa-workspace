package io.fluentqa.tc.service.impl;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.StrUtil;
import io.fluentqa.base.proxies.AuditDataEnhancerProxy;
import io.fluentqa.pm.product.model.ProductModuleModel;
import io.fluentqa.pm.product.service.ProductModuleService;
import io.fluentqa.tc.dto.TestCaseDTO;
import io.fluentqa.tc.model.TestCase;
import io.fluentqa.tc.repo.TestCaseRepo;
import io.fluentqa.tc.service.TestCaseService;
import org.apache.commons.math3.stat.descriptive.summary.Product;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class TestCaseServiceImpl implements TestCaseService {
    @Resource
    private TestCaseRepo testCaseRepo;
    @Resource
    private ProductModuleService productMetaService;

    @Resource
    private AuditDataEnhancerProxy
            auditDataEnhancerProxy;
    @Override
    @Transactional
    @Async
    /**
     * notice:parent Product can't be created
     * Two scenarios:
     * 1. New Cases added: uuid is null
     *    A. Use Excel Product/Module
     *    B. Us Excel Product/Module is not existing, use file upload Product Module
     * 2. Existing Case updated:
     *    A. UUID is found, and update the existing row
     *    B. UUID is not found, create a new row
     */
    public void saveProductCases(List<TestCaseDTO> cases, ProductModuleModel parentProduct, ProductModuleModel module) {
        for (TestCaseDTO aCase : cases) {
            TestCase tcEntity;
            if (StrUtil.isBlank(aCase.getUuid())) {
                tcEntity = BeanUtil.copyProperties(aCase, TestCase.class);
                tcEntity.setUuid(UUID.fastUUID().toString(true));
            } else {
                tcEntity = testCaseRepo.findByUuid(aCase.getUuid());
                if (tcEntity == null) {
                    tcEntity = BeanUtil.copyProperties(aCase, TestCase.class);
                } else {
                    BeanUtil.copyProperties(aCase, tcEntity, "id");
                }
            }

            if (StrUtil.isBlank(aCase.getUuid())) {
                tcEntity.setUuid(UUID.randomUUID().toString());
            }
            Product subModule;
            if (module != null) {
                subModule = productMetaService.createModuleIfNotExist(module.getId(), aCase.getModuleName());
            } else {
                subModule = productMetaService.createModuleIfNotExist(parentProduct.getId(), aCase.getModuleName());
            }
            tcEntity.setModule(subModule);

            if (tcEntity.getPriority() == null) {
                tcEntity.setPriority("P2");
            }
            tcEntity.setSteps(StrUtil.join("\n", aCase.getFeature(),
                    aCase.getSummary(), aCase.getSteps()));
            auditDataEnhancerProxy.enhanceTimeAndUserAuditData(tcEntity);
            testCaseRepo.save(tcEntity);
        }
    }
}
