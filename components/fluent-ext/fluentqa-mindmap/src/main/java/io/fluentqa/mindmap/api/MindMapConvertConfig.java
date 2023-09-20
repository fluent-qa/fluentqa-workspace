package io.fluentqa.mindmap.api;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MindMapConvertConfig {
    private List<LevelConfig> configs = new ArrayList<>();

    @Data
    @AllArgsConstructor
    public static class LevelConfig{
        private String key;
        private Integer level;
    }

    public MindMapConvertConfig add(LevelConfig config){
        this.configs.add(config);
        return this;
    }
}
