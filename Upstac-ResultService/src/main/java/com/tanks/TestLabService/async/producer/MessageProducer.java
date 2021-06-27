package com.tanks.TestLabService.async.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.tanks.TestLabService.model.TestBooking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageProducer {

    private String kafkaTopic = "feedback";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void send(TestBooking testBooking) {
        try {
            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String json = ow.writeValueAsString(testBooking);
            System.out.println(json);
            kafkaTemplate.send(kafkaTopic, json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
