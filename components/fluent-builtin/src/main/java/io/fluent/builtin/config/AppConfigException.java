package io.fluent.builtin.config;

public class AppConfigException extends RuntimeException {
  public AppConfigException() {
    super();
  }

  public AppConfigException(final String message) {
    super(message);
  }

  public AppConfigException(final String message, Throwable cause) {
    super(message, cause);
  }

  public AppConfigException(Throwable cause) {
    super(cause);
  }

  protected AppConfigException(
      final String message,
      Throwable cause,
      boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
