/**
 * Resumen.
 * Objeto                   : OperationActiveRestController.java
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
import com.nttdata.bootcamp.bank.springboot.document.OperationActive;
import com.nttdata.bootcamp.bank.springboot.service.inte.OperationActiveServiceInte;
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
@RequestMapping("/api/business-microservice03-operation/operationActive")
public class OperationActiveRestController {
    private static final Logger log = LoggerFactory.getLogger(OperationActiveRestController.class);

    @Autowired
    private OperationActiveServiceInte operationActiveServiceInte;

    @PostMapping()
    public Mono<OperationActive> create(@RequestBody final OperationActive operationActive) {
        log.debug("Begin RestController create OperationActive");
        return operationActiveServiceInte.create(operationActive);
    }

    @GetMapping
    public Flux<OperationActive> readAll() {
        log.debug("Begin RestController readAll OperationActive");
        return operationActiveServiceInte.readAll();
    }

    @GetMapping("findByid/{id}")
    public Mono<OperationActive> findByCodeOperationActive(@PathVariable String codeOperationActive) {
        log.debug("Begin RestController findByCodeOperationActive OperationActive");
        return operationActiveServiceInte.findByCodeId(codeOperationActive);
    }

    @PutMapping("/{id}")
    public Mono<OperationActive> updateById(@RequestBody final OperationActive operationActive, @PathVariable("id") final String id) {
        log.debug("Begin RestController updateById OperationActive");
        return operationActiveServiceInte.updateById(id, operationActive);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteById(@PathVariable final String id) {
        log.debug("Begin RestController deleteById OperationActive");
        return operationActiveServiceInte.deleteById(id);
    }

}
