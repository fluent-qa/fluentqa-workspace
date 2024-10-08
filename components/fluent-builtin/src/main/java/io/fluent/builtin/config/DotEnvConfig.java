package io.fluent.builtin.config;

import io.github.cdimascio.dotenv.Dotenv;

/**
 * For .env configuration
 */
public class DotEnvConfig {

  static Dotenv dotenv = Dotenv.load();

  public static String getValue(String key) {
    return dotenv.get(key);
  }
}
