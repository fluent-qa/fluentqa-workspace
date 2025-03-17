package io.fluent.mindmap.api;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class MindMapConvertConfig {
  private List<LevelConfig> configs = new ArrayList<>();

  @Data
  @AllArgsConstructor
  public static class LevelConfig {
    private String key;
    private Integer level;
  }

  public MindMapConvertConfig add(LevelConfig config) {
    this.configs.add(config);
    return this;
  }
}
