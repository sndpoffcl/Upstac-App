package com.tanks.TestLabService.utility;

import com.tanks.TestLabService.entity.TestResultDO;
import com.tanks.TestLabService.model.TestBooking;
import com.tanks.TestLabService.model.TestResult;
import org.springframework.stereotype.Component;

@Component
public class DTOEntityConverter {
    public TestResultDO convertTestBookingToTestResultDO(TestBooking testBooking){
        TestResultDO testResultDO = new TestResultDO();
        testResultDO.setStatus(testBooking.getStatus());
        testResultDO.setBookingNo(testBooking.getBookingNo());
        testResultDO.setTrackingNo(testBooking.getTrackingNo());
        testResultDO.setTestCode(testBooking.getTestCode());
        testResultDO.setMedicineReq(testBooking.isMedicineReq());
        return testResultDO;
    }

    public TestResultDO convertTestResultToTestResultDO(TestResult testResult){
        TestResultDO testResultDO = new TestResultDO();
        testResultDO.setStatus("REPORT_GENERATED");
        testResultDO.setTestResult(testResult.getTestResult());
        testResultDO.setTrackingNo(testResult.getTrackingNo());
        return testResultDO;
    }


}
