package io.fluentqa.mindmap.exception;

public class MindMapException extends RuntimeException{
    public MindMapException() {
    }

    public MindMapException(String message) {
        super(message);
    }

    public MindMapException(String message, Throwable cause) {
        super(message, cause);
    }

    public MindMapException(Throwable cause) {
        super(cause);
    }

    public MindMapException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
