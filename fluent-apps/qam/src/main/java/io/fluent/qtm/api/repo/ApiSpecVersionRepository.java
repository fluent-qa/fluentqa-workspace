package io.fluent.qtm.api.repo;

import io.fluent.qtm.api.model.ApiSpecVersionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApiSpecVersionRepository extends JpaRepository<ApiSpecVersionModel, Long> {

}