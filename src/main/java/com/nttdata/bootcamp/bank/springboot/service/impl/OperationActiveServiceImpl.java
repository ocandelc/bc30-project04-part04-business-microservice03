/**
 * Resumen.
 * Objeto                   : OperationActiveServiceImpl.java
 * Descripción              : Clase de implementación de servicio para utilizar los métodos de CRUD.
 * Fecha de Creación        : 24/08/2022.
 * Proyecto de Creación     : Bootcamp-30.
 * Autor                    : Mario Vásquez.
 * ---------------------------------------------------------------------------------------------------------------------------
 * Modificaciones
 * Motivo                   Fecha             Nombre                  Descripción
 * ---------------------------------------------------------------------------------------------------------------------------
 */
package com.nttdata.bootcamp.bank.springboot.service.impl;
import com.nttdata.bootcamp.bank.springboot.dao.inte.OperationActiveDaoInte;
import com.nttdata.bootcamp.bank.springboot.document.OperationActive;
import com.nttdata.bootcamp.bank.springboot.service.inte.OperationActiveServiceInte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Clase de implementación de servicio para utilizar los métodos de CRUD.
 */
@Service
public class OperationActiveServiceImpl implements OperationActiveServiceInte {
    private static final Logger log = LoggerFactory.getLogger(OperationActiveServiceImpl.class);

    @Autowired
    private OperationActiveDaoInte operationActiveDaoInte;

    @Override
    public Mono<OperationActive> create(final OperationActive operationActive) {
        return operationActiveDaoInte.save(operationActive)
                .doFirst(() -> log.info("Begin create OperationActive"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish create OperationActive"));
    }

    @Override
    public Flux<OperationActive> readAll() {

        return operationActiveDaoInte.findAll()
                .doFirst(() -> log.info("Begin readAll OperationActive"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish readAll OperationActive"));
    }

    @Override
    public Mono<OperationActive> findByCodeId(String codeOperationActive) {
        return operationActiveDaoInte.findById(codeOperationActive)
                .doFirst(() -> log.info("Begin findByCodeOperationActive OperationActive"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish findByCodeOperationActive OperationActive"));
    }

    @Override
    public Mono<OperationActive> updateById(final String id, final OperationActive operationActive) {

        return operationActiveDaoInte.save(operationActive)
                .doFirst(() -> log.info("Begin updateById operationActive"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish updateById OperationActive"));
    }

    @Override
    public Mono<Void> deleteById(final String id) {

        return operationActiveDaoInte.deleteById(id)
                .doFirst(() -> log.info("Begin deleteById OperationActive"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish deleteById OperationActive"));
    }
}
