package com.tanks.TestLabService.validator;

import com.tanks.TestLabService.exception.APIException;
import com.tanks.TestLabService.model.TestBooking;
import com.tanks.TestLabService.model.TestResult;
import com.tanks.TestLabService.utility.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class TestBookingValidatorImpl implements TestBookingValidator{

    @Override
    public void validateTestBooking(TestBooking booking) throws APIException {
        if(StringUtils.isEmptyOrNull(booking.getTrackingNo())){
            throw new APIException("Invalid tracking no");
        }
        if(booking.getBookingNo() <= 0){
            throw new APIException("Invalid booking no");
        }
        if(StringUtils.isEmptyOrNull(booking.getTestCode())){
            throw new APIException("Invalid test code");
        }
    }

    @Override
    public void validateTestResult(TestResult testResult) throws APIException {
        if(StringUtils.isEmptyOrNull(testResult.getTrackingNo())){
            throw new APIException("Invalid tracking no");
        }
        if(StringUtils.isEmptyOrNull(testResult.getTestResult())){
            throw new APIException("Invalid test result");
        }
    }
}
