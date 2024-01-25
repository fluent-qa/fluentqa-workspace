package io.fluentqa.qtm.api.repo;

import io.fluentqa.qtm.api.model.RawApiTestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RawApiTestCaseRepo extends JpaRepository<RawApiTestCase, Long>, JpaSpecificationExecutor<Long> {
}
