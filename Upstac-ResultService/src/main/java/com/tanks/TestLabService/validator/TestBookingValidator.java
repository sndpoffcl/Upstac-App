package com.tanks.TestLabService.validator;

import com.tanks.TestLabService.exception.APIException;
import com.tanks.TestLabService.model.TestBooking;
import com.tanks.TestLabService.model.TestResult;

public interface TestBookingValidator {
    public void validateTestBooking(TestBooking booking) throws APIException;
    public void validateTestResult(TestResult testResult) throws  APIException;
}
