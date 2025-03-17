package io.fluentqa.qtm.api.repo;

import io.fluentqa.qtm.api.model.ApiSpecGitRepoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApiSpecGitRepoRepository extends JpaRepository<ApiSpecGitRepoModel, Long> {

}