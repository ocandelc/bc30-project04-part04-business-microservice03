package com.nttdata.bootcamp.bank.kafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

    @Autowired
    //private final KafkaTemplate<String, String> kafkaTemplate;
    private KafkaTemplate<String, Object> kafkaTemplate;

    /*
    public KafkaProducer(@Qualifier("kafkaStringTemplate") KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }*/

    public void sendMessageString(String message) {
        LOGGER.info("Producing message {}", message);
        //this.kafkaTemplate.send("TOPIC-DEMO", message);
        kafkaTemplate.send("TOPIC-DEMO", message);
    }

    public void sendMessageObject(Object object) {
        LOGGER.info("Producing message {}", object);
        //this.kafkaTemplate.send("TOPIC-DEMO", message);
        kafkaTemplate.send("TOPIC-DEMO", object);
    }
}