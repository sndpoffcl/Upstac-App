package com.upstac.TestLab.async.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.upstac.TestLab.model.TestBooking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageProducer {

    private String kafkaTopic = "collector";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void send(TestBooking testBooking) {
        try {
            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String json = ow.writeValueAsString(testBooking);
            kafkaTemplate.send(kafkaTopic, json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
