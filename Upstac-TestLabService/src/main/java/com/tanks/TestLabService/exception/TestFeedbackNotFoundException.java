package com.tanks.TestLabService.exception;

public class TestFeedbackNotFoundException extends RuntimeException {
    public TestFeedbackNotFoundException() {
    }

    public TestFeedbackNotFoundException(String message) {
        super(message);
    }

    public TestFeedbackNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public TestFeedbackNotFoundException(Throwable cause) {
        super(cause);
    }

    public TestFeedbackNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
