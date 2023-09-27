package io.fluentqa.pm.product.service;

import io.fluentqa.pm.product.model.ProductModuleModel;
import io.fluentqa.pm.product.repo.ProductModuleRepo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class ProductModuleService {
    private final String API_SERVICE="API";
    @Resource
    private ProductModuleRepo metaRepo;
    public ProductModuleModel createModuleIfNotExist(Long productId, String moduleName){
        Optional<ProductModuleModel> meta = metaRepo.findProductByParentIdAndNameAndValid(productId,
                moduleName,true);
        if(meta.isPresent()) return meta.get();
        ProductModuleModel parent = new ProductModuleModel();
        parent.setId(productId);
        ProductModuleModel module = new ProductModuleModel();
        module.setName(moduleName);
        module.setDetails(moduleName);
        module.setParent(parent);
        return metaRepo.save(module);
    }

    public ProductModuleModel findApiServiceProduct(){
        Optional<ProductModuleModel> meta = metaRepo.findProductByCodeAndValid(API_SERVICE,true);
        if(meta.isPresent()) return meta.get();
        throw new RuntimeException("Please config API Service as a Product in Product Meta");
    }

    public ProductModuleModel createApiModuleIfNotExist(String moduleName){
        ProductModuleModel parent = findApiServiceProduct();
        return createModuleIfNotExist(parent.getId(),moduleName);
    }
}
