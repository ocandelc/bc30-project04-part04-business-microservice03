package com.nttdata.bootcamp.bank.springboot.controller;

import com.nttdata.bootcamp.bank.springboot.document.OperationPassive;
import com.nttdata.bootcamp.bank.springboot.service.inte.OperationPassiveServiceInte;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import reactor.core.publisher.Flux;

@SpringBootTest
public class OperationPassiveRestControllerTest {

    @MockBean
    private OperationPassiveServiceInte operationPassiveServiceInte;

    @Test
    void readAllTest() {

        Flux<OperationPassive> fluxOperationPassive = operationPassiveServiceInte.readAll();

        Mockito.verify(operationPassiveServiceInte).readAll();

     }

}
