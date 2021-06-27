package com.upstac.TestLab.exception;

public class BookingAlreadyExistsException extends RuntimeException{
    public BookingAlreadyExistsException() {
    }

    public BookingAlreadyExistsException(String message) {
        super(message);
    }

    public BookingAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookingAlreadyExistsException(Throwable cause) {
        super(cause);
    }

    public BookingAlreadyExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
