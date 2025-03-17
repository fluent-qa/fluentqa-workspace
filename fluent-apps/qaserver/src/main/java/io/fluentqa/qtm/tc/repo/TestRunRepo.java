package io.fluentqa.qtm.tc.repo;


import io.fluentqa.qtm.tc.model.TestRun;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRunRepo extends JpaRepository<TestRun,Long> {

}
