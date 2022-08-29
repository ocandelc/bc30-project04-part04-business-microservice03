/**
 * Resumen.
 * Objeto                   : OperationTypeServiceImpl.java
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
import com.nttdata.bootcamp.bank.springboot.dao.inte.OperationTypeDaoInte;
import com.nttdata.bootcamp.bank.springboot.document.OperationType;
import com.nttdata.bootcamp.bank.springboot.service.inte.OperationTypeServiceInte;
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
public class OperationTypeServiceImpl implements OperationTypeServiceInte {
    private static final Logger log = LoggerFactory.getLogger(OperationTypeServiceImpl.class);

    @Autowired
    private OperationTypeDaoInte operationTypeDaoInte;

    @Override
    public Mono<OperationType> create(final OperationType operationType) {
        return operationTypeDaoInte.save(operationType)
                .doFirst(() -> log.info("Begin create OperationType"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish create OperationType"));
    }

    @Override
    public Flux<OperationType> readAll() {

        return operationTypeDaoInte.findAll()
                .doFirst(() -> log.info("Begin readAll OperationType"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish readAll OperationType"));
    }

    @Override
    public Mono<OperationType> findByCodeId(String codeOperationType) {
        return operationTypeDaoInte.findById(codeOperationType)
                .doFirst(() -> log.info("Begin findByCodeOperationType OperationType"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish findByCodeOperationType OperationType"));
    }

    @Override
    public Mono<OperationType> updateById(final String id, final OperationType operationType) {

        return operationTypeDaoInte.save(operationType)
                .doFirst(() -> log.info("Begin updateById operationType"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish updateById OperationType"));
    }

    @Override
    public Mono<Void> deleteById(final String id) {

        return operationTypeDaoInte.deleteById(id)
                .doFirst(() -> log.info("Begin deleteById OperationType"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish deleteById OperationType"));
    }
}
