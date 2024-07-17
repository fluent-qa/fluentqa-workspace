package io.fluent.builtin.config;

import static org.junit.jupiter.api.Assertions.*;

import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

public class AppConfigTest {
  @Test
  @Story("Get All Configuration")
  public void test_GetSetting() {
    var appConfig = AppConfig.create();
    assertNotNull(appConfig);
  }

  @Test
  @Story("Get Configuration Property")
  public void test_LoadSetting() {
    var appConfig = AppConfig.create("config/app2.setting");
    assertNotNull(appConfig);
    assertEquals(appConfig.getConfigSetByGroupName("demo").get("user"), "root${demo.driver}");
  }

  @Test
  @Story("Get Configuration to a Bean")
  public void test_GetGroupSetting() {
    var appConfig = AppConfig.create();
    var bean = appConfig.getConfigSetBean(DemoSetting.class);
    assertEquals(bean.getUser(), "root${demo.driver}");
  }
}
