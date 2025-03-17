package io.fluentqa.qtm.api.repo;

import io.fluentqa.qtm.api.model.ApiSpecVersionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApiSpecVersionRepository extends JpaRepository<ApiSpecVersionModel, Long> {

}