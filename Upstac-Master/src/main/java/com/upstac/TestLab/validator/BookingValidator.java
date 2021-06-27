package com.upstac.TestLab.validator;

import com.upstac.TestLab.exception.APIException;
import com.upstac.TestLab.model.Booking;

public interface BookingValidator {
    public void validateBooking(Booking booking) throws APIException;
}
