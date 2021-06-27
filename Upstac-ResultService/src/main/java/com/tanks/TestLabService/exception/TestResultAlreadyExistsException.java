package com.tanks.TestLabService.exception;

public class TestResultAlreadyExistsException extends RuntimeException{
    public TestResultAlreadyExistsException() {
    }

    public TestResultAlreadyExistsException(String message) {
        super(message);
    }

    public TestResultAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public TestResultAlreadyExistsException(Throwable cause) {
        super(cause);
    }

    public TestResultAlreadyExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
