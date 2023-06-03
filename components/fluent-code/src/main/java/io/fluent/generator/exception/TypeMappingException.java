package io.fluent.generator.exception;

public class TypeMappingException extends RuntimeException{
    public TypeMappingException() {
        super("Type Mapping is not Existing,Please Register TypeMapping");
    }

    public TypeMappingException(String message) {
        super(message);
    }

    public TypeMappingException(String message, Throwable cause) {
        super(message, cause);
    }

    public TypeMappingException(Throwable cause) {
        super(cause);
    }

    protected TypeMappingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
