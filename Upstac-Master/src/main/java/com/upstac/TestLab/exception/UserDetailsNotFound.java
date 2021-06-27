package com.upstac.TestLab.exception;

public class UserDetailsNotFound extends RuntimeException{

    public UserDetailsNotFound() {
    }

    public UserDetailsNotFound(String message) {
        super(message);
    }

    public UserDetailsNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public UserDetailsNotFound(Throwable cause) {
        super(cause);
    }

    public UserDetailsNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
