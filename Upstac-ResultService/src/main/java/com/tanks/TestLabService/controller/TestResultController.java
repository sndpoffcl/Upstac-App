package com.tanks.TestLabService.controller;

import com.tanks.TestLabService.async.producer.MessageProducer;
import com.tanks.TestLabService.entity.TestResultDO;
import com.tanks.TestLabService.model.TestBooking;
import com.tanks.TestLabService.model.TestResult;
import com.tanks.TestLabService.service.TestResultService;
import com.tanks.TestLabService.utility.DTOEntityConverter;
import com.tanks.TestLabService.utility.EntityDTOConverter;
import com.tanks.TestLabService.validator.TestBookingValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestResultController {

    private static final Logger logger = LoggerFactory.getLogger(TestResultController.class);

    @Autowired
    TestResultService testResultService;

    @Autowired
    TestBookingValidator testBookingValidator;

    @Autowired
    EntityDTOConverter entityDTOConverter;

    @Autowired
    DTOEntityConverter dtoEntityConverter;

    @Autowired
    MessageProducer messageProducer;


    @GetMapping("/testBooking")
    public ResponseEntity getAllTestBooking(){
        return ResponseEntity.ok(testResultService.getAllTestResults());
    }

    @GetMapping("/testBooking/{id}")
    public ResponseEntity getTestBookingDetails(@PathVariable("id") int id){
        logger.info("getTestBookingDetails : start", id);
        TestResultDO testResultDO = testResultService.getTestResult(id);
        return ResponseEntity.ok(entityDTOConverter.getTestBookingFromTestResultDO(testResultDO));
    }

    @PostMapping("/testBooking")
    public ResponseEntity addTestResult(@RequestBody TestResult testResult){
        logger.info("addTestResult : start", testResult);
        testBookingValidator.validateTestResult(testResult);
        TestResultDO updatedTestResultDO = testResultService.updateTestResult(dtoEntityConverter.convertTestResultToTestResultDO(testResult));

        TestBooking test = new TestBooking();
        test.setTestResult(updatedTestResultDO.getTestResult());
        test.setTrackingNo(updatedTestResultDO.getTrackingNo());
        test.setBookingNo(updatedTestResultDO.getBookingNo());
        test.setStatus(updatedTestResultDO.getStatus());
        test.setTestCode(updatedTestResultDO.getTestCode());
        test.setMedicineReq(updatedTestResultDO.isMedicineReq());

        messageProducer.send(test);
        return ResponseEntity.ok(updatedTestResultDO);
    }
}
