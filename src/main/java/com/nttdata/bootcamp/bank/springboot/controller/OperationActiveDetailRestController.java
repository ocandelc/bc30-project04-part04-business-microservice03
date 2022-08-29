/**
 * Resumen.
 * Objeto                   : OperationActiveDetailRestController.java
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
import com.nttdata.bootcamp.bank.springboot.document.OperationActiveDetail;
import com.nttdata.bootcamp.bank.springboot.service.inte.OperationActiveDetailServiceInte;
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
@RequestMapping("/api/business-microservice03-operation/operationActiveDetail")
public class OperationActiveDetailRestController {
    private static final Logger log = LoggerFactory.getLogger(OperationActiveDetailRestController.class);

    @Autowired
    private OperationActiveDetailServiceInte operationActiveDetailServiceInte;

    @PostMapping()
    public Mono<OperationActiveDetail> create(@RequestBody final OperationActiveDetail operationActiveDetail) {
        log.debug("Begin RestController create OperationActiveDetail");
        return operationActiveDetailServiceInte.create(operationActiveDetail);
    }

    @GetMapping
    public Flux<OperationActiveDetail> readAll() {
        log.debug("Begin RestController readAll OperationActiveDetail");
        return operationActiveDetailServiceInte.readAll();
    }

    @GetMapping("findByid/{id}")
    public Mono<OperationActiveDetail> findByCodeOperationActiveDetail(@PathVariable String codeOperationActiveDetail) {
        log.debug("Begin RestController findByCodeOperationActiveDetail OperationActiveDetail");
        return operationActiveDetailServiceInte.findByCodeId(codeOperationActiveDetail);
    }

    @PutMapping("/{id}")
    public Mono<OperationActiveDetail> updateById(@RequestBody final OperationActiveDetail operationActiveDetail, @PathVariable("id") final String id) {
        log.debug("Begin RestController updateById OperationActiveDetail");
        return operationActiveDetailServiceInte.updateById(id, operationActiveDetail);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteById(@PathVariable final String id) {
        log.debug("Begin RestController deleteById OperationActiveDetail");
        return operationActiveDetailServiceInte.deleteById(id);
    }

}
