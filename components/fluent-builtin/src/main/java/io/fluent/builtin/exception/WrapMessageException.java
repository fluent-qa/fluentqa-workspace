package io.fluent.builtin.exception;

/**
 * 只包装了 错误信息 的 {@link RuntimeException}.
 *

 */
public class WrapMessageException extends RuntimeException {

    public WrapMessageException(String message) {
        super(message);
    }

    public WrapMessageException(String message, Throwable cause) {
        super(message, cause);
    }

}
