package io.fluent.builtin.exception;

public class SystemException extends WrapMessageException {
    private static final long serialVersionUID = 1L;

    public SystemException(String message) {
        super(message);
    }

    public SystemException(String message, Throwable cause) {
        super(message, cause);
    }
}
