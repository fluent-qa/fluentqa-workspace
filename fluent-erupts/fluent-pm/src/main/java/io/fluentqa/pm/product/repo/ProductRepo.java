package io.fluentqa.pm.product.repo;


import io.fluentqa.pm.product.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<ProductModel, Long>, JpaSpecificationExecutor<Long> {

    Optional<ProductModel> findProductByNameAndValid(String name, boolean valid);

    Optional<ProductModel> findProductByCodeAndValid(String codeName, boolean valid);
    Optional<ProductModel> findProductByParentIdAndNameAndValid(Long parentId, String name, boolean valid);
}
