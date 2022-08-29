/**
 * Resumen.
 * Objeto                   : OperationActiveDetailServiceInte.java
 * Descripción              : Clase de interface de servicio para utilizar los métodos de CRUD.
 * Fecha de Creación        : 24/08/2022.
 * Proyecto de Creación     : Bootcamp-30.
 * Autor                    : Oscar Candela.
 * ---------------------------------------------------------------------------------------------------------------------------
 * Modificaciones
 * Motivo                   Fecha             Nombre                  Descripción
 * ---------------------------------------------------------------------------------------------------------------------------
 * Bootcamp-30              25/08/2022        Oscar Candela           Realizar la creación de un método nuevo.
 */
package com.nttdata.bootcamp.bank.springboot.service.inte;
import com.nttdata.bootcamp.bank.springboot.document.OperationActiveDetail;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Clase de interface de servicio para utilizar los métodos de CRUD.
 */
public interface OperationActiveDetailServiceInte {
    Mono<OperationActiveDetail> create(final OperationActiveDetail operationActiveDetail);

    Flux<OperationActiveDetail> readAll();

    Mono<OperationActiveDetail> findByCodeId(String codeOperationActiveDetail);

    Mono<OperationActiveDetail> updateById(final String id, final OperationActiveDetail operationActiveDetail);

    Mono<Void> deleteById(final String id);
}
