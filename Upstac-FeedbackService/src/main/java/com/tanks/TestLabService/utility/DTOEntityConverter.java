package com.tanks.TestLabService.utility;

import com.tanks.TestLabService.entity.TestFeedBackDO;
import com.tanks.TestLabService.model.TestBooking;
import com.tanks.TestLabService.model.TestFeedback;
import org.springframework.stereotype.Component;

@Component
public class DTOEntityConverter {
    public TestFeedBackDO convertTestBookingToTestFeedbackDO(TestBooking testBooking){
        TestFeedBackDO testFeedBackDO = new TestFeedBackDO();
        testFeedBackDO.setStatus(testBooking.getStatus());
        testFeedBackDO.setBookingNo(testBooking.getBookingNo());
        testFeedBackDO.setTrackingNo(testBooking.getTrackingNo());
        testFeedBackDO.setTestResult(testBooking.getTestResult());
        testFeedBackDO.setMedicineReq(testBooking.isMedicineReq());
        return testFeedBackDO;
    }

    public TestFeedBackDO convertTestFeedBackToTestFeedbackDO(TestFeedback testFeedback){
        TestFeedBackDO testFeedBackDO = new TestFeedBackDO();
        testFeedBackDO.setStatus("FEEDBACK_GENERATED");
        testFeedBackDO.setTestFeedBack(testFeedback.getTestFeedback());
        testFeedBackDO.setTrackingNo(testFeedback.getTrackingNo());
        return testFeedBackDO;
    }
}
