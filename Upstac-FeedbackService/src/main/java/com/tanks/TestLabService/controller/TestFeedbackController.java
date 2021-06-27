package com.tanks.TestLabService.controller;

import com.tanks.TestLabService.async.producer.MessageProducer;
import com.tanks.TestLabService.entity.TestFeedBackDO;
import com.tanks.TestLabService.model.TestBooking;
import com.tanks.TestLabService.model.TestFeedback;
import com.tanks.TestLabService.service.TestFeedBackService;
import com.tanks.TestLabService.utility.DTOEntityConverter;
import com.tanks.TestLabService.utility.EntityDTOConverter;
import com.tanks.TestLabService.validator.TestBookingValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class TestFeedbackController {

    private static final Logger logger = LoggerFactory.getLogger(TestFeedbackController.class);

    @Autowired
    TestFeedBackService testFeedBackService;

    @Autowired
    TestBookingValidator testBookingValidator;

    @Autowired
    EntityDTOConverter entityDTOConverter;

    @Autowired
    DTOEntityConverter dtoEntityConverter;

    @Autowired
    MessageProducer messageProducer;


    @GetMapping("/testBookingFeedback")
    public ResponseEntity getAllTestBookingFeedback(){
        return ResponseEntity.ok(testFeedBackService.getAllTestFeedbacks());
    }

    @GetMapping("/testBookingFeedback/{id}")
    public ResponseEntity getTestBookingDetails(@PathVariable("id") int id){
        logger.info("testBookingFeedbackDetails : start", id);
        TestFeedBackDO testFeedBackDO = testFeedBackService.getTestFeedback(id);
        return ResponseEntity.ok(entityDTOConverter.convertTestFeedBackDOToTestBooking(testFeedBackDO));
    }

    @PostMapping("/testBookingFeedback")
    public ResponseEntity addTestResult(@RequestBody TestFeedback testFeedback){
        logger.info("testBookingFeedback : start", testFeedback);
        testBookingValidator.validateTestFeedback(testFeedback);
        TestFeedBackDO updatedTestFeedbackDO = testFeedBackService.updateTestFeedback(dtoEntityConverter.convertTestFeedBackToTestFeedbackDO(testFeedback));

        TestBooking test = new TestBooking();
        test.setTestResult(updatedTestFeedbackDO.getTestResult());
        test.setTrackingNo(updatedTestFeedbackDO.getTrackingNo());
        test.setBookingNo(updatedTestFeedbackDO.getBookingNo());
        test.setStatus(updatedTestFeedbackDO.getStatus());
        test.setTestFeedBack(updatedTestFeedbackDO.getTestFeedBack());
        messageProducer.send(test);
        return ResponseEntity.ok(updatedTestFeedbackDO);
    }
}
