/**
 * Resumen.
 * Objeto                   : OperationTypeRestController.java
 * Descripción              : Clase de controller para invocar los métodos con rest api.
 * Fecha de Creación        : 24/08/2022.
 * Proyecto de Creación     : Bootcamp-30.
 * Autor                    : Mario Vásquez.
 * ---------------------------------------------------------------------------------------------------------------------------
 * Modificaciones
 * Motivo                   Fecha             Nombre                  Descripción
 * ---------------------------------------------------------------------------------------------------------------------------
 * Bootcamp-30              25/08/2022        Oscar Candela           Modificación de la url.
 */
package com.nttdata.bootcamp.bank.springboot.controller;
import com.nttdata.bootcamp.bank.springboot.document.OperationType;
import com.nttdata.bootcamp.bank.springboot.service.inte.OperationTypeServiceInte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Clase de controller para invocar los métodos con rest api.
 */
@RestController
@RequestMapping("/api/business-microservice03-operation/operationType")
public class OperationTypeRestController {
    private static final Logger log = LoggerFactory.getLogger(OperationTypeRestController.class);

    @Autowired
    private OperationTypeServiceInte operationTypeServiceInte;

    @PostMapping()
    public Mono<OperationType> create(@RequestBody final OperationType operationType) {
        log.debug("Begin RestController create OperationType");
        return operationTypeServiceInte.create(operationType);
    }

    @GetMapping
    public Flux<OperationType> readAll() {
        log.debug("Begin RestController readAll OperationType");
        return operationTypeServiceInte.readAll();
    }

    @GetMapping("findByid/{id}")
    public Mono<OperationType> findByCodeOperationType(@PathVariable String codeOperationType) {
        log.debug("Begin RestController findByCodeOperationType OperationType");
        return operationTypeServiceInte.findByCodeId(codeOperationType);
    }

    @PutMapping("/{id}")
    public Mono<OperationType> updateById(@RequestBody final OperationType operationType, @PathVariable("id") final String id) {
        log.debug("Begin RestController updateById OperationType");
        return operationTypeServiceInte.updateById(id, operationType);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteById(@PathVariable final String id) {
        log.debug("Begin RestController deleteById OperationType");
        return operationTypeServiceInte.deleteById(id);
    }

}
