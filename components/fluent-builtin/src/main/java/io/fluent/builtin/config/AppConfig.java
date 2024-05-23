package io.fluent.builtin.config;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.setting.Setting;
import io.fluent.builtin.StringUtils;
import io.fluent.builtin.meta.ReflectionUtils;
import java.util.HashMap;

public class AppConfig {
  Setting setting;

  private AppConfig() {}

  private static final String DEFAULT_SETTING_PATH = "config/app.setting";

  public static AppConfig create() {
    return create(DEFAULT_SETTING_PATH);
  }

  /**
   * Create Setting by setting Paths
   *
   * @param settingPath
   * @return
   */
  public static AppConfig create(String settingPath) {
    AppConfig config = new AppConfig();
    config.setting = new Setting(settingPath);
    config.setting.autoLoad(true);
    return config;
  }

  public void addSystemProperties() {
    setting.putAll(PropUtils.getSystemProps().toBean(HashMap.class));
  }

  public Setting getSetting() {
    return setting;
  }

  public Setting getConfigSetByGroupName(String groupName) {
    return this.setting.getSetting(groupName);
  }

  public <T> T getConfigSetBean(String groupName, Class<T> beanType) {
    var groupSetting = getConfigSetByGroupName(groupName);
    return BeanUtil.toBean(groupSetting, beanType);
  }

  public <T> T getConfigSetBean(Class<T> beanType) {
    ConfigGroupName groupName =
        ReflectionUtils.getClassLevelAnnotation(beanType, ConfigGroupName.class);
    if (groupName != null && StringUtils.isBlank(groupName.name())) {
      throw new AppConfigException(beanType.getName() + "is not annotated by ConfigGroupName");
    }
    var groupSetting = getConfigSetByGroupName(groupName.name());
    return BeanUtil.toBean(groupSetting, beanType);
  }
}
