package io.fluent.qtm.api.repo;

import io.fluent.qtm.api.model.ApiTestScenario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ApiTestScenarioRepo extends JpaRepository<ApiTestScenario, Long>, JpaSpecificationExecutor<Long> {
}
