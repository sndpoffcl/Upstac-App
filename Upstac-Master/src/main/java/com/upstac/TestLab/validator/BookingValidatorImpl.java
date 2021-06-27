package com.upstac.TestLab.validator;

import com.upstac.TestLab.exception.APIException;
import com.upstac.TestLab.model.Booking;
import org.springframework.stereotype.Component;

@Component
public class BookingValidatorImpl implements BookingValidator{
    @Override
    public void validateBooking(Booking booking) throws APIException {
        if(booking.getCustomerId() <= 0){
            throw new APIException("Customer ID is invalid");
        }
        if(booking.getTestId() <= 0){
            throw new APIException("Test ID is invalid");
        }
    }
}
