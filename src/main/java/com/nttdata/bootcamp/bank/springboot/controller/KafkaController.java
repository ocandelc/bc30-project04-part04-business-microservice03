package com.nttdata.bootcamp.bank.springboot.controller;

import com.nttdata.bootcamp.bank.kafka.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api/business-microservice03-operation/kafka")
public class KafkaController {

    @Autowired
    private KafkaProducer kafkaProducer;
    //private final KafkaProducer kafkaProducer;

    /*@Autowired
    KafkaController(KafkaProducer kafkaProducer) {

        this.kafkaProducer = kafkaProducer;
    }*/

    @PostMapping(value = "/publish/demo01")
    public Mono<String> sendMessageToKafkaTopic(@RequestParam("message") String message) {
        //this.kafkaProducer.sendMessage(message);
        kafkaProducer.sendMessageString(message);
        return Mono.just(message);
    }

    @PostMapping(value = "/publish/demo02")
    public Mono<String> sendMessageToKafkaTopicDemo() {
        String message01 = "Soy tu prueba";
        //this.kafkaProducer.sendMessage(message01);
        kafkaProducer.sendMessageString(message01);
        return Mono.just(message01);
    }

}
