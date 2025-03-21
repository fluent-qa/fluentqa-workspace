package io.fluent.base.product.service;

import io.fluent.builtin.PingYinUtils;
import io.fluent.base.product.repo.ProductModuleRepo;
import io.fluent.base.proxies.AuditDataEnhancerProxy;
import io.fluent.base.masterdata.repo.MasterDataRepo;
import io.fluent.base.product.model.ProductModuleModel;
import io.fluent.base.masterdata.model.MasterData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class ProductModuleService {
    @Resource
    private ProductModuleRepo metaRepo;

    @Resource
    private MasterDataRepo masterDataRepo;

    @Resource
    AuditDataEnhancerProxy dataEnhancerProxy;

    public ProductModuleModel createModuleIfNotExist(Long productId, String moduleName, String updater) {
        Optional<ProductModuleModel> meta = metaRepo.findProductByParentIdAndNameAndValid(productId,
                moduleName, true);
        if (meta.isPresent()) return meta.get();
        ProductModuleModel parent = new ProductModuleModel();
        parent.setId(productId);
        ProductModuleModel module = new ProductModuleModel();
        module.setName(moduleName);
        module.setDetails(moduleName);
        module.setParent(parent);
        module.setCode(PingYinUtils.convertToPinyinAbbreviation(moduleName));
        MasterData data = masterDataRepo.findMasterDataByCode("MODULE").get();
        module.setMetaType(data.getId().toString());
        dataEnhancerProxy.enhanceTimeAndUserAuditData(module,updater);
        return metaRepo.save(module);
    }

    public ProductModuleModel findApiServiceProduct() {
        String API_SERVICE = "API";
        Optional<ProductModuleModel> meta = metaRepo.findProductByCodeAndValid(API_SERVICE, true);
        if (meta.isPresent()) return meta.get();
        throw new RuntimeException("Please config API Service as a Product in Product Meta");
    }

    public ProductModuleModel createApiModuleIfNotExist(String moduleName,String updater) {
        ProductModuleModel parent = findApiServiceProduct();
        return createModuleIfNotExist(parent.getId(), moduleName,updater);
    }

    public ProductModuleModel findByName(String productName) {
        return metaRepo.findProductByNameAndValid(productName, true).orElse(null);
    }
}
