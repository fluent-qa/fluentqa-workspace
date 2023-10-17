package io.fluent.quickdao.exceptions;

public class DbExecutionFoundException extends RuntimeException{
  public DbExecutionFoundException() {
  }

  public DbExecutionFoundException(String message) {
    super(message);
  }

  public DbExecutionFoundException(String message, Throwable cause) {
    super(message, cause);
  }

  public DbExecutionFoundException(Throwable cause) {
    super(cause);
  }

  public DbExecutionFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
