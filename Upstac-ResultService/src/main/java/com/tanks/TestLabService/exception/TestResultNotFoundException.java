package com.tanks.TestLabService.exception;

public class TestResultNotFoundException extends RuntimeException {
    public TestResultNotFoundException() {
    }

    public TestResultNotFoundException(String message) {
        super(message);
    }

    public TestResultNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public TestResultNotFoundException(Throwable cause) {
        super(cause);
    }

    public TestResultNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
