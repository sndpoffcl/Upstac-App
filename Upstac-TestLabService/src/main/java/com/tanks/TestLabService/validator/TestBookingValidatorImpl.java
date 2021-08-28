package com.tanks.TestLabService.validator;

import com.tanks.TestLabService.exception.APIException;
import com.tanks.TestLabService.model.TestBooking;
import com.tanks.TestLabService.model.TestFeedback;
import com.tanks.TestLabService.utility.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class TestBookingValidatorImpl implements TestBookingValidator{

    @Override
    public void validateTestBooking(TestBooking booking) throws APIException {
        if(StringUtils.isEmptyOrNull(booking.getTrackingNo())){
            throw new APIException("Invalid tracking no");
        }
        if(StringUtils.isEmptyOrNull(booking.getTestResult())){
            throw new APIException("Invalid test result");
        }
        if(booking.getBookingNo() <= 0){
            throw new APIException("Invalid booking no");
        }
        if(StringUtils.isEmptyOrNull(booking.getTestCode())){
            throw new APIException("Invalid test code");
        }
    }

    @Override
    public void validateTestFeedback(TestFeedback testFeedback) throws APIException {
        if(StringUtils.isEmptyOrNull(testFeedback.getTrackingNo())){
            throw new APIException("Invalid tracking no");
        }
        if(StringUtils.isEmptyOrNull(testFeedback.getTestFeedback())){
            throw new APIException("Invalid test feedback");
        }
    }


}
