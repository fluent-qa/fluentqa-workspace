package io.fluentqa.qtm.pm.project.repo;


import io.fluentqa.qtm.pm.product.model.ProductModuleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProjectModelRepo extends JpaRepository<ProductModuleModel, Long>, JpaSpecificationExecutor<Long> {

    Optional<ProductModuleModel> findProductByNameAndValid(String name, boolean valid);

    Optional<ProductModuleModel> findProductByCodeAndValid(String codeName, boolean valid);
    Optional<ProductModuleModel> findProductByParentIdAndNameAndValid(Long parentId, String name, boolean valid);
}
