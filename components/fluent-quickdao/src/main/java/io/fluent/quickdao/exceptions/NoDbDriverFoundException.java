package io.fluent.quickdao.exceptions;

public class NoDbDriverFoundException extends RuntimeException {
  public NoDbDriverFoundException() {}

  public NoDbDriverFoundException(String message) {
    super(message);
  }

  public NoDbDriverFoundException(String message, Throwable cause) {
    super(message, cause);
  }

  public NoDbDriverFoundException(Throwable cause) {
    super(cause);
  }

  public NoDbDriverFoundException(
      String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
