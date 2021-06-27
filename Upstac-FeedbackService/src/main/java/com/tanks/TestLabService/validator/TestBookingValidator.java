package com.tanks.TestLabService.validator;

import com.tanks.TestLabService.exception.APIException;
import com.tanks.TestLabService.model.TestBooking;
import com.tanks.TestLabService.model.TestFeedback;

public interface TestBookingValidator {
    public void validateTestBooking(TestBooking booking) throws APIException;
    public void validateTestFeedback(TestFeedback testFeedback) throws APIException;
}
