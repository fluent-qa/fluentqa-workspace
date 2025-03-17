package io.fluent.mindmap.api;

import cn.hutool.core.bean.BeanUtil;
import io.fluent.builtin.meta.ReflectionUtils;
import java.lang.reflect.Field;
import java.util.*;
import java.util.function.Function;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class MindMapPathRecord {
  private Map<Integer, String> mindMapLevels = new HashMap<>();

  private Integer currentLevel = 0;

  private synchronized void increaseTreeLevel() {
    this.currentLevel++;
  }

  public void add(String value) {
    increaseTreeLevel();
    mindMapLevels.put(this.currentLevel, value);
  }

  public Map<Integer, String> getMindMapLevels() {
    return mindMapLevels;
  }

  public <T> T toBean(Class<T> clazz, MindMapConvertConfig config) {
    T instance = ReflectionUtils.newInstance(clazz);
    for (MindMapConvertConfig.LevelConfig levelConfig : config.getConfigs()) {
      try {
        BeanUtil.setFieldValue(
            instance, levelConfig.getKey(), this.mindMapLevels.get(levelConfig.getLevel()));
      } catch (Exception e) {
        log.error("ignore the error=", e);
      }
    }
    return instance;
  }

  public <T> T toBean(Class<T> clazz) {
    T instance = ReflectionUtils.newInstance(clazz);
    Field[] fields = ReflectionUtils.getFields(clazz);
    for (Field field : fields) {
      NodeLevel a = field.getAnnotation(NodeLevel.class);
      if (a != null) {
        ReflectionUtils.setFieldValue(instance, field, this.mindMapLevels.get(a.value()));
      }
    }
    return instance;
  }

  public static <T> MindMapPathRecord fromMindMapPath(
      MindMapPath<T> path, Function<T, String> extractValueFunc) {
    MindMapPathRecord record = new MindMapPathRecord();
    for (T pathNode : path.getPathNodes()) {
      record.add(extractValueFunc.apply(pathNode));
    }
    return record;
  }

  public static <T> List<MindMapPathRecord> fromMindMapPaths(
      List<MindMapPath<T>> paths, Function<T, String> extractValueFunc) {
    List<MindMapPathRecord> records = new ArrayList<>();
    paths.forEach((t) -> records.add(fromMindMapPath(t, extractValueFunc)));
    return records;
  }
}
