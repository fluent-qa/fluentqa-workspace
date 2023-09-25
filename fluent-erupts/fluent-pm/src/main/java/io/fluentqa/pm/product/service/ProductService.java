package io.fluentqa.pm.product.service;

import io.fluentqa.pm.product.model.ProductModel;
import io.fluentqa.pm.product.repo.ProductRepo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class ProductService {
    private final String API_SERVICE="API";
    @Resource
    private ProductRepo metaRepo;
    public ProductModel createModuleIfNotExist(Long productId, String moduleName){
        Optional<ProductModel> meta = metaRepo.findProductByParentIdAndNameAndValid(productId,
                moduleName,true);
        if(meta.isPresent()) return meta.get();
        ProductModel parent = new ProductModel();
        parent.setId(productId);
        ProductModel module = new ProductModel();
        module.setName(moduleName);
        module.setDetails(moduleName);
        module.setParent(parent);
        return metaRepo.save(module);
    }

    public ProductModel findApiServiceProduct(){
        Optional<ProductModel> meta = metaRepo.findProductByCodeAndValid(API_SERVICE,true);
        if(meta.isPresent()) return meta.get();
        throw new RuntimeException("Please config API Service as a Product in Product Meta");
    }

    public ProductModel createApiModuleIfNotExist(String moduleName){
        ProductModel parent = findApiServiceProduct();
        return createModuleIfNotExist(parent.getId(),moduleName);
    }
}
