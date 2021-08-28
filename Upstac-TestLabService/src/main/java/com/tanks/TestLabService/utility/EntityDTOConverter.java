package com.tanks.TestLabService.utility;

import com.tanks.TestLabService.entity.TestFeedBackDO;
import com.tanks.TestLabService.model.TestBooking;
import org.springframework.stereotype.Component;

@Component
public class EntityDTOConverter {

    public TestBooking convertTestFeedBackDOToTestBooking(TestFeedBackDO testFeedBackDO){
        TestBooking testBooking = new TestBooking();
        testBooking.setBookingNo(testFeedBackDO.getBookingNo());
        testBooking.setTestFeedBack(testFeedBackDO.getTestFeedBack());
        testBooking.setStatus(testFeedBackDO.getStatus());
        testBooking.setTrackingNo(testFeedBackDO.getTrackingNo());

        return testBooking;
    }
}
