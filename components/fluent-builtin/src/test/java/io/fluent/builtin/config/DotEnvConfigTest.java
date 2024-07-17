package io.fluent.builtin.config;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DotEnvConfigTest {

  @Test
  public void testGetValue() {
    var result = DotEnvConfig.getValue("TW_BEAR_TOKEN");
    System.out.println(result);
  }
}
