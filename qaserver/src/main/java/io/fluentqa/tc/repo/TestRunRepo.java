package io.fluentqa.tc.repo;


import io.fluentqa.tc.model.TestRun;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRunRepo extends JpaRepository<TestRun,Long> {

}
