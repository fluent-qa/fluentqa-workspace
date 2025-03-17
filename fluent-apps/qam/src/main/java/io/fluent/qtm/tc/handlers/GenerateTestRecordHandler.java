package io.fluent.qtm.tc.handlers;


import cn.hutool.core.bean.BeanUtil;
import io.fluent.qtm.tc.model.TestCase;
import io.fluent.qtm.tc.model.TestResult;
import io.fluent.qtm.tc.model.TestRun;
import io.fluent.qtm.tc.model.TestScenario;
import io.fluent.qtm.tc.repo.TestResultRepo;

import org.springframework.stereotype.Service;
import xyz.erupt.annotation.fun.OperationHandler;


import javax.annotation.Resource;
import java.util.List;

@Service
public class GenerateTestRecordHandler implements OperationHandler<TestRun, Void> {
    @Resource
    private TestResultRepo testResultRepo;

    @Override
    public String exec(List<TestRun> data, Void unused, String[] param) {
        for (TestRun testRun : data) {
            //get all test cases
            for (TestCase testCase : testRun.getTestCases()) {
                TestResult result = BeanUtil.copyProperties(testCase, TestResult.class);
                result.setTestCaseUUID(testCase.getUuid());
                result.setTestRun(testRun);
                result.setQaOwner(testRun.getTestOwner());
                testResultRepo.save(result);
            }
            for (TestScenario tc : testRun.getTestScenarios()) {
                for (TestCase testCase : tc.getTestCases()) {
                    TestResult result = BeanUtil.copyProperties(testCase, TestResult.class);
                    result.setTestCaseUUID(testCase.getUuid());
                    result.setTestRun(testRun);
                    result.setQaOwner(testRun.getTestOwner());
                    result.setTestScenario(tc.getName());
                    testResultRepo.save(result);
                }
            }
        }
        return null;
    }


}
