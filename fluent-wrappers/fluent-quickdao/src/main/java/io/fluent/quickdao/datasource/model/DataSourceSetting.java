package io.fluent.quickdao.datasource.model;

import static io.fluent.quickdao.constants.DefaultConstants.POSTGRESQL;

import cn.hutool.core.lang.Dict;
import cn.hutool.setting.Setting;
import java.util.Map;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DataSourceSetting extends Dict {
  private String url;
  private String username;
  private String password;
  private String driver;
  @Builder.Default private String dbType = POSTGRESQL;

  public Setting toSetting() {
    Setting setting = Setting.create();

    for (Map.Entry<String, Object> entry : this.entrySet()) {
      setting.put(entry.getKey(), entry.getValue().toString());
    }
    setting.put("url", url);
    setting.put("username", username);
    setting.put("password", password);
    setting.put("driver", driver);
    for (Map.Entry<String, Object> entry : this.entrySet()) {
      setting.put(entry.getKey(), entry.getValue().toString());
    }
    return setting;
  }
}
