package io.fluentqa.builtin.config;

import lombok.Data;

@ConfigGroupName(name = "demo")
@Data
public class DemoSetting {
  private String driver;
  private String url;
  private String user;
  private String pass;
}
