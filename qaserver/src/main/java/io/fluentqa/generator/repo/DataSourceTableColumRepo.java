package io.fluentqa.generator.repo;

import io.fluentqa.generator.model.DataSourceTableColumModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import org.springframework.stereotype.Repository;

@Repository
public interface DataSourceTableColumRepo extends JpaRepository<DataSourceTableColumModel, Long>,
        JpaSpecificationExecutor<Long> {
}
