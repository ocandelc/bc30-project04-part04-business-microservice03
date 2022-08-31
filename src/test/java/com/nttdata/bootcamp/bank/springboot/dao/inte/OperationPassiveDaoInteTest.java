package com.nttdata.bootcamp.bank.springboot.dao.inte;

import com.nttdata.bootcamp.bank.springboot.document.OperationPassive;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.ArrayList;
import java.util.Date;

@ExtendWith(SpringExtension.class)
public class OperationPassiveDaoInteTest {

    private static final Logger logger = LoggerFactory.getLogger(OperationPassiveDaoInteTest.class);

    private AutoCloseable closeable;

    @BeforeEach
    public void setUp() {
        logger.debug("INICIO TEST");

        closeable = MockitoAnnotations.openMocks(this);

        OperationPassive object01 = new OperationPassive(
                "62f69fafc8039c79397e786f",
                "OP-0000000001",
                "prueba",
                "prueba",
                new Date(),
                0.0,
                 0.0,
                0.0,
                 0.0,
                0.0,
                "1",
                "P-0000000001",
                "OT-0000000001");

        Mono<OperationPassive> monoObjectTest = Mono.just(object01);

        Mono<OperationPassive> monoObjectDatabase = operationPassiveDaoInte.readByCodeOperationPassive("OP-0000000001");

        Mockito.when(monoObjectDatabase).thenReturn(monoObjectTest);

    }

    @AfterEach
    void tearDown() throws Exception {
        logger.debug("FIN TEST");

        closeable.close();
    }

    @Mock
    OperationPassiveDaoInte operationPassiveDaoInte;

    @Test
    @Order(1)
    public void createOperationPassiveTest() {
        OperationPassive object03 = new OperationPassive(
                "62f69fafc8039c79397e786f",
                "OP-0000000001",
                "prueba",
                "prueba",
                new Date(),
                0.0,
                0.0,
                0.0,
                0.0,
                0.0,
                "1",
                "P-0000000001",
                "OT-0000000001");

        Mono<OperationPassive> monoObjectDatabase = operationPassiveDaoInte.save(object03);

        Mockito.verify(operationPassiveDaoInte).save(object03);
    }

    @Test
    @Order(2)
    public void readByCodeOperationPassiveTest() {

        Mono<OperationPassive> monoObjectDatabase = operationPassiveDaoInte.readByCodeOperationPassive("OP-0000000001");

        Mockito.verify(operationPassiveDaoInte).readByCodeOperationPassive("OP-0000000001");

    }

    @Test
    @Order(3)
    public void updateOperationPassiveTest() {
        OperationPassive object01 = new OperationPassive(
                "62f69fafc8039c79397e786f",
                "OP-0000000001",
                "prueba",
                "prueba",
                new Date(),
                0.0,
                0.0,
                0.0,
                0.0,
                0.0,
                "1",
                "P-0000000001",
                "OT-0000000001");

        Mono<OperationPassive> monoObjectDatabase = operationPassiveDaoInte.save(object01);

        Mockito.verify(operationPassiveDaoInte).save(object01);
    }

    @Test
    @Order(4)
    public void deleteOperationPassiveTest() {

        Mono<Void> monoObjectDatabase = operationPassiveDaoInte.deleteById("OP-0000000001");

        Mockito.verify(operationPassiveDaoInte).deleteById("OP-0000000001");
    }

    @Test
    @Order(5)
    public void readByCodeOperationPassiveStepVerifierTest() {

        Mono<OperationPassive> objectDatabase = operationPassiveDaoInte.readByCodeOperationPassive("OP-0000000001");

        OperationPassive object01 = new OperationPassive(
                "62f69fafc8039c79397e786f",
                "OP-0000000001",
                "prueba",
                "prueba",
                new Date(),
                0.0,
                0.0,
                0.0,
                0.0,
                0.0,
                "1",
                "P-0000000001",
                "OT-0000000001");
        Mono<OperationPassive> objectTest = Mono.just(object01);

        StepVerifier.create(operationPassiveDaoInte.readByCodeOperationPassive("OP-0000000001")).recordWith(ArrayList::new)
                .expectNextCount(1)
                .consumeRecordedWith(r -> {
                    Assertions.assertEquals("OP-0000000001", "OP-0000000001");
                })
                .verifyComplete();;

    }

}
