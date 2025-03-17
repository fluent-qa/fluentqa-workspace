package io.fluent.qtm.api.repo;

import io.fluent.qtm.api.model.ApiSpecGitRepoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApiSpecGitRepoRepository extends JpaRepository<ApiSpecGitRepoModel, Long> {

}