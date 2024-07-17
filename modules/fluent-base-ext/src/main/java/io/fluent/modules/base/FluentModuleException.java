package io.fluent.modules.base;

public class FluentModuleException extends RuntimeException {
  public FluentModuleException() {
    super();
  }

  public FluentModuleException(String message) {
    super(message);
  }

  public FluentModuleException(String message, Throwable cause) {
    super(message, cause);
  }

  public FluentModuleException(Throwable cause) {
    super(cause);
  }

  protected FluentModuleException(
      String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
