package io.fluentqa.pm.project.repo;


import io.fluentqa.pm.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProjectRepo extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Long> {

    Optional<Product> findProductByNameAndValid(String name, boolean valid);

    Optional<Product> findProductByCodeAndValid(String codeName, boolean valid);
    Optional<Product> findProductByParentIdAndNameAndValid(Long parentId, String name, boolean valid);
}
