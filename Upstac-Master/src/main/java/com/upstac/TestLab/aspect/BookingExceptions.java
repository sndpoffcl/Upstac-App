package com.upstac.TestLab.aspect;

import com.upstac.TestLab.exception.BookingAlreadyExistsException;
import com.upstac.TestLab.exception.BookingDetailsNotFoundException;
import com.upstac.TestLab.model.CustomResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BookingExceptions {
    @ExceptionHandler(BookingDetailsNotFoundException.class)
    public ResponseEntity<CustomResponse> handleBookingDetailsNotFoundException(Exception e){
        CustomResponse response = new CustomResponse(e.getMessage(), HttpStatus.EXPECTATION_FAILED.value());
        return  new ResponseEntity<>(response, HttpStatus.EXPECTATION_FAILED);
    }

    @ExceptionHandler(BookingAlreadyExistsException.class)
    public ResponseEntity<CustomResponse> handleBookingAlreadyExistsException(Exception e){
        CustomResponse response = new CustomResponse(e.getMessage(), HttpStatus.EXPECTATION_FAILED.value());
        return  new ResponseEntity<>(response, HttpStatus.EXPECTATION_FAILED);
    }
}
