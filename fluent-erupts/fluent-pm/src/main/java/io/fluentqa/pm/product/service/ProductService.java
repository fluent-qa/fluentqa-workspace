package io.fluentqa.pm.product.service;

import io.fluentqa.pm.product.model.Product;
import io.fluentqa.pm.product.repo.ProductRepo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class ProductService {
    private final String API_SERVICE="API";
    @Resource
    private ProductRepo metaRepo;
    public Product createModuleIfNotExist(Long productId, String moduleName){
        Optional<Product> meta = metaRepo.findProductByParentIdAndNameAndValid(productId,
                moduleName,true);
        if(meta.isPresent()) return meta.get();
        Product parent = new Product();
        parent.setId(productId);
        Product module = new Product();
        module.setName(moduleName);
        module.setDetails(moduleName);
        module.setParent(parent);
        return metaRepo.save(module);
    }

    public Product findApiServiceProduct(){
        Optional<Product> meta = metaRepo.findProductByCodeAndValid(API_SERVICE,true);
        if(meta.isPresent()) return meta.get();
        throw new RuntimeException("Please config API Service as a Product in Product Meta");
    }

    public Product createApiModuleIfNotExist(String moduleName){
        Product parent = findApiServiceProduct();
        return createModuleIfNotExist(parent.getId(),moduleName);
    }
}
