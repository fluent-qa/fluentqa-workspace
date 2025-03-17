package io.fluentqa.qtm.api.repo;


import io.fluentqa.qtm.api.model.ApiSpecChangeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApiSpecChangeRepository extends JpaRepository<ApiSpecChangeModel, Long> {

}