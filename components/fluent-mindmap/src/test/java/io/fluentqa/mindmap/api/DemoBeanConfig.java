package io.fluentqa.mindmap.api;

public class DemoBeanConfig {

    public static MindMapConvertConfig loadConfig(){
        MindMapConvertConfig configs = new MindMapConvertConfig();
        configs.add(new MindMapConvertConfig.LevelConfig("moduleName",1))
                .add(new MindMapConvertConfig.LevelConfig("featureName",2))
                .add(new MindMapConvertConfig.LevelConfig("testCase",3))
                .add(new MindMapConvertConfig.LevelConfig("testSteps",4))
                .add(new MindMapConvertConfig.LevelConfig("expectedResult",5));
        return configs;
    }
}
