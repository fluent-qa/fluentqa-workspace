package io.fluentqa.tc.repo;


import io.fluentqa.tc.model.TestResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "testResultRepo")
public interface TestResultRepo extends JpaRepository<TestResult,Long> {

}
