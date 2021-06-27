package com.upstac.TestLab.exception;

public class TestDetailsNotFoundException extends RuntimeException{

    public TestDetailsNotFoundException() {
    }

    public TestDetailsNotFoundException(String message) {
        super(message);
    }

    public TestDetailsNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public TestDetailsNotFoundException(Throwable cause) {
        super(cause);
    }

    public TestDetailsNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
