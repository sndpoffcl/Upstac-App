package com.tanks.TestLabService.utility;

import com.tanks.TestLabService.entity.TestResultDO;
import com.tanks.TestLabService.model.TestBooking;
import org.springframework.stereotype.Component;

@Component
public class EntityDTOConverter {

    public TestBooking getTestBookingFromTestResultDO(TestResultDO testResultDO){
        TestBooking testBooking = new TestBooking();
        testBooking.setBookingNo(testResultDO.getBookingNo());
        testBooking.setTestResult(testResultDO.getTestResult());
        testBooking.setTrackingNo(testResultDO.getTrackingNo());
        testBooking.setStatus(testResultDO.getStatus());
        return testBooking;
    }
}
