/**
 * Resumen.
 * Objeto                   : OperationActiveDetailServiceImpl.java
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
import com.nttdata.bootcamp.bank.springboot.dao.inte.OperationActiveDetailDaoInte;
import com.nttdata.bootcamp.bank.springboot.document.OperationActiveDetail;
import com.nttdata.bootcamp.bank.springboot.service.inte.OperationActiveDetailServiceInte;
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
public class OperationActiveDetailServiceImpl implements OperationActiveDetailServiceInte {
    private static final Logger log = LoggerFactory.getLogger(OperationActiveDetailServiceImpl.class);

    @Autowired
    private OperationActiveDetailDaoInte operationActiveDetailDaoInte;

    @Override
    public Mono<OperationActiveDetail> create(final OperationActiveDetail operationActiveDetail) {
        return operationActiveDetailDaoInte.save(operationActiveDetail)
                .doFirst(() -> log.info("Begin create OperationActiveDetail"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish create OperationActiveDetail"));
    }

    @Override
    public Flux<OperationActiveDetail> readAll() {

        return operationActiveDetailDaoInte.findAll()
                .doFirst(() -> log.info("Begin readAll OperationActiveDetail"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish readAll OperationActiveDetail"));
    }

    @Override
    public Mono<OperationActiveDetail> findByCodeId(String codeOperationActiveDetail) {
        return operationActiveDetailDaoInte.findById(codeOperationActiveDetail)
                .doFirst(() -> log.info("Begin findByCodeOperationActiveDetail OperationActiveDetail"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish findByCodeOperationActiveDetail OperationActiveDetail"));
    }

    @Override
    public Mono<OperationActiveDetail> updateById(final String id, final OperationActiveDetail operationActiveDetail) {

        return operationActiveDetailDaoInte.save(operationActiveDetail)
                .doFirst(() -> log.info("Begin updateById operationActiveDetail"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish updateById OperationActiveDetail"));
    }

    @Override
    public Mono<Void> deleteById(final String id) {

        return operationActiveDetailDaoInte.deleteById(id)
                .doFirst(() -> log.info("Begin deleteById OperationActiveDetail"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish deleteById OperationActiveDetail"));
    }
}
