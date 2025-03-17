package io.fluentqa.qtm.tc.repo;

import io.fluentqa.qtm.tc.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestCaseRepo extends JpaRepository<TestCase,Long> {
    public TestCase findByUuid(String uuid);


//    @Query(nativeQuery = true,value = "delete from test_cases where test_plan=:testPlan")
//    @Modifying
//    public void deleteByTestPlan(@Param("testPlan") String testPlan);
}
