package com.nttdata.bootcamp.bank.springboot.controller;

import com.nttdata.bootcamp.bank.kafka.producer.KafkaProducer;
import com.nttdata.bootcamp.bank.springboot.document.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api/business-microservice03-operation/kafkaProducer/operationPassive")
public class KafkaProducerLocationRestController {

    @Autowired
    private KafkaProducer kafkaProducer;

    /*@PostMapping(value = "/publish/demo03")
    public Mono<String> sendMessageToKafkaTopicDemo() {
        String message01 = "Soy tu prueba 03";
        //this.kafkaProducer.sendMessage(message01);
        kafkaProducer.sendMessageString(message01);
        return Mono.just(message01);
    }*/

    @PostMapping(value = "/publish/location")
    public Mono<String> sendMessageToKafkaLocation(@RequestBody final Location location) throws InterruptedException {
        String message01 = "Soy tu prueba 04";
        //this.kafkaProducer.sendMessage(message01);
        kafkaProducer.sendMessageObject(location);
        return Mono.just(message01);
    }

}
