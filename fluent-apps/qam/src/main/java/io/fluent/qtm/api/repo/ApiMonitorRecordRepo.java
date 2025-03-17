package io.fluent.qtm.api.repo;

import io.fluent.qtm.api.model.ApiMonitorRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApiMonitorRecordRepo extends JpaRepository<ApiMonitorRecord, Long>, JpaSpecificationExecutor<Long> {

    List<ApiMonitorRecord> findApiMonitorRecordByPath(String path);
}
