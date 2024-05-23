package io.fluent.modules.base;

import io.fluent.builtin.config.AppConfig;
import java.util.ArrayList;
import java.util.List;
import lombok.Builder;
import lombok.Data;

public class PluginSettings {
  public static List<PluginSetting> loadPlugins(String plugins) {
    String[] pluginClasses = plugins.split(",");
    List<PluginSetting> pluginSettings = new ArrayList<>();
    for (String pluginClass : pluginClasses) {
      pluginSettings.add(PluginSetting.builder().className(pluginClass).build());
    }
    return pluginSettings;
  }

  public static List<PluginSetting> loadPlugins() {
    String plugins = AppConfig.create().getSetting().get("plugins");
    return loadPlugins(plugins);
  }

  public static List<PluginSetting> loadPluginsByConfig(String filePath) {
    String plugins = AppConfig.create(filePath).getSetting().get("plugins");
    return loadPlugins(plugins);
  }

  @Builder
  @Data
  public static class PluginSetting {
    private String className;
  }
}
