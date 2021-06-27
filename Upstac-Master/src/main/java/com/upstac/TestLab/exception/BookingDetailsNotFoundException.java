package com.upstac.TestLab.exception;

public class BookingDetailsNotFoundException extends RuntimeException{
    public BookingDetailsNotFoundException() {
    }

    public BookingDetailsNotFoundException(String message) {
        super(message);
    }

    public BookingDetailsNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookingDetailsNotFoundException(Throwable cause) {
        super(cause);
    }

    public BookingDetailsNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
