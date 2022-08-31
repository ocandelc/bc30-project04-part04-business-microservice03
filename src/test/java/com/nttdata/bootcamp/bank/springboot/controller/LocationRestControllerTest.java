package com.nttdata.bootcamp.bank.springboot.controller;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LocationRestControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    @Order(1)
    void readAllTest() {

        webTestClient.get()
                .uri("http://localhost:8094/api/business-microservice04-location/location/")
                .exchange()
                .expectStatus().isOk();

     }

    @Test
    @Order(2)
    void readByCodeLocationTest() {

        webTestClient.get()
                .uri("http://localhost:8094/api/business-microservice04-location/location/readByCodeLocation/L-0000000001")
                .exchange()
                .expectStatus().isOk();

    }
}
