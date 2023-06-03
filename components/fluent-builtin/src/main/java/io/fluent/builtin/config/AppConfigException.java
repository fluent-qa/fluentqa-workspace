package io.fluent.builtin.config;

public class AppConfigException extends RuntimeException{
  public AppConfigException() {
    super();
  }

  public AppConfigException(String message) {
    super(message);
  }

  public AppConfigException(String message, Throwable cause) {
    super(message, cause);
  }

  public AppConfigException(Throwable cause) {
    super(cause);
  }

  protected AppConfigException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
