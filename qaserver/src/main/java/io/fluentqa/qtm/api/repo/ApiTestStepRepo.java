package io.fluentqa.qtm.api.repo;

import io.fluentqa.qtm.api.model.ApiStep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ApiTestStepRepo extends JpaRepository<ApiStep, Long>, JpaSpecificationExecutor<Long> {
}
