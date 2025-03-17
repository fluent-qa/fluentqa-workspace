package io.fluentqa.qtm.tc.repo;


import io.fluentqa.qtm.tc.model.TestResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "testResultRepo")
public interface TestResultRepo extends JpaRepository<TestResult,Long> {

}
