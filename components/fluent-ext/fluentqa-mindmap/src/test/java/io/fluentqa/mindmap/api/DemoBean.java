package io.fluentqa.mindmap.api;

import lombok.Data;

@Data
public class DemoBean {
    @NodeLevel(1)
    private String moduleName;
    @NodeLevel(2)

    private String featureName;
    @NodeLevel(3)

    private String testCase;
    @NodeLevel(4)

    private String testSteps;
    @NodeLevel(5)

    private  String expectedResult;
}
