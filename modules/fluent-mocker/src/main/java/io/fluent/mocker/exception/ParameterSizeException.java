package io.fluent.mocker.exception;

public class ParameterSizeException extends MockException {
    public ParameterSizeException() {
        super("参数数量与方法参数数量不符！");
    }
}
