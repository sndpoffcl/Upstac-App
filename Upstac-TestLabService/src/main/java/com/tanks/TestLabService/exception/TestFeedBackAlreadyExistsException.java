package com.tanks.TestLabService.exception;

public class TestFeedBackAlreadyExistsException extends RuntimeException{
    public TestFeedBackAlreadyExistsException() {
    }

    public TestFeedBackAlreadyExistsException(String message) {
        super(message);
    }

    public TestFeedBackAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public TestFeedBackAlreadyExistsException(Throwable cause) {
        super(cause);
    }

    public TestFeedBackAlreadyExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
