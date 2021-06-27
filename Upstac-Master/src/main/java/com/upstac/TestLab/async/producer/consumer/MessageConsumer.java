package com.upstac.TestLab.async.producer.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.upstac.TestLab.entity.BookingDO;
import com.upstac.TestLab.model.TestBooking;
import com.upstac.TestLab.service.BookingService;
import com.upstac.TestLab.utility.DTOEntityConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class MessageConsumer {

    @Autowired
    DTOEntityConverter dtoEntityConverter;

    @Autowired
    BookingService bookingService;

    @KafkaListener(topics = "master", groupId = "group_id")
    public void consume(String message) throws IOException {
        TestBooking consumedTestBooking = new ObjectMapper().readValue(message, TestBooking.class);
        System.out.println("#### Consumed message : " + consumedTestBooking.toString());
        BookingDO consumedTestResult = dtoEntityConverter.convertTestBookingToBookingDO(consumedTestBooking);
        bookingService.updateBookingWithResultAndFeedback(consumedTestResult);
    }
}
