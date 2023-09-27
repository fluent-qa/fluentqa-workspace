package io.fluentqa.tc.service.impl;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.StrUtil;
import io.fluentqa.base.proxies.AuditDataEnhancerProxy;
import io.fluentqa.pm.product.model.ProductModel;
import io.fluentqa.pm.product.service.ProductService;
import io.fluentqa.tc.dto.TestCaseDTO;
import io.fluentqa.tc.model.TestCase;
import io.fluentqa.tc.repo.TestCaseRepo;
import io.fluentqa.tc.service.TestCaseService;
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
    private ProductService productMetaService;

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
    public void saveProductCases(List<TestCaseDTO> cases, ProductModel parentProduct, ProductModel module) {
        for (TestCaseDTO aCase : cases) {
            TestCase tcEntity;
            if(StrUtil.isBlank(aCase.getUuid())) {
                tcEntity = BeanUtil.copyProperties(aCase, TestCase.class);
                tcEntity.setUuid( UUID.fastUUID().toString(true));
            }else{
                tcEntity = testCaseRepo.findTestCaseByUuid(aCase.getUuid());
                if(tcEntity == null){
                    tcEntity = BeanUtil.copyProperties(aCase, TestCase.class);
                }else{
                    BeanUtil.copyProperties(aCase,tcEntity,"id");
                }
            }

            if (StrUtil.isBlank(aCase.getUuid())) {
                tcEntity.setUuid(UUID.randomUUID().toString());
            }
            tcEntity.setProduct(parentProduct);
            if (StrUtil.isBlank(aCase.getModuleName())) {
                tcEntity.setModule(module);
            } else {
                ProductModel newModule = productMetaService.createModuleIfNotExist(parentProduct.getId(), aCase.getModuleName());
                tcEntity.setModule(newModule);
            }
            if(tcEntity.getPriority() ==null) {
                tcEntity.setPriority("P2");
            }
            tcEntity.setProduct(parentProduct);
            auditDataEnhancerProxy.enhanceTimeAndUserAuditData(tcEntity);
            testCaseRepo.save(tcEntity);
        }
    }
}
