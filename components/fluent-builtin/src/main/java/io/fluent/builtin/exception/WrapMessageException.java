package io.fluent.builtin.exception;

/**
 * 只包装了 错误信息 的 {@link RuntimeException}.
 * 用于 {@link com.sprainkle.spring.cloud.advance.common.core.exception.assertion.Assert} 中用于包装自定义异常信息
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
