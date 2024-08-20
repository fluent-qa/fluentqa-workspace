package io.fluent.builtin.strings;

import io.fluent.builtin.NamingUtils;
import org.junit.jupiter.api.Test;

public class NamingUtilsTest {

  @Test
  void underscoreToCamel() {

    var result = NamingUtils.underscoreToCamel("test_nice_new");
    assert result.equalsIgnoreCase("testNiceNew");
  }

  @Test
  void camelToUnderscore() {}
}
