package com.tanks.TestLabService.async.consumer;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.tanks.TestLabService.entity.TestFeedBackDO;
import com.tanks.TestLabService.exception.TestFeedBackAlreadyExistsException;
import com.tanks.TestLabService.model.TestBooking;
import com.tanks.TestLabService.service.TestFeedBackService;
import com.tanks.TestLabService.utility.DTOEntityConverter;
import com.tanks.TestLabService.validator.TestBookingValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class MessageConsumer {

    @Autowired
    DTOEntityConverter dtoEntityConverter;

    @Autowired
    TestFeedBackService testFeedBackService;

    @Autowired
    TestBookingValidator testBookingValidator;

    @KafkaListener(topics = "feedback", groupId = "group_id")
    public void consume(String message) throws IOException, TestFeedBackAlreadyExistsException {
        TestBooking consumedTestBooking = new ObjectMapper().readValue(message, TestBooking.class);
        System.out.println("#### Consumed message : " + consumedTestBooking.toString());
        testBookingValidator.validateTestBooking(consumedTestBooking);
        TestFeedBackDO consumedTestResult = dtoEntityConverter.convertTestBookingToTestFeedbackDO(consumedTestBooking);
        testFeedBackService.addTestFeedBack(consumedTestResult);
    }
}
