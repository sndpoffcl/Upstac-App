package com.tanks.TestLabService.async.consumer;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.tanks.TestLabService.entity.TestResultDO;
import com.tanks.TestLabService.exception.TestResultAlreadyExistsException;
import com.tanks.TestLabService.model.TestBooking;
import com.tanks.TestLabService.service.TestResultService;
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
    TestResultService testResultService;

    @Autowired
    TestBookingValidator testBookingValidator;

    @KafkaListener(topics = "collector", groupId = "group_id")
    public void consume(String message) throws IOException, TestResultAlreadyExistsException {
        TestBooking consumedTestBooking = new ObjectMapper().readValue(message, TestBooking.class);
        System.out.println("#### Consumed message : " + consumedTestBooking.toString());
        testBookingValidator.validateTestBooking(consumedTestBooking);
        TestResultDO consumedTestResult = dtoEntityConverter.convertTestBookingToTestResultDO(consumedTestBooking);
        testResultService.addTestResult(consumedTestResult);
    }
}
