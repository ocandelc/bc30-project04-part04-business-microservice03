/**
 * Resumen.
 * Objeto                   : OperationActiveDaoInte.java
 * Descripción              : Clase de interface dao para obtener los datos de la base de datos.
 * Fecha de Creación        : 24/08/2022.
 * Proyecto de Creación     : Bootcamp-30.
 * Autor                    : Mario Vásquez.
 * ---------------------------------------------------------------------------------------------------------------------------
 * Modificaciones
 * Motivo                   Fecha             Nombre                  Descripción
 * ---------------------------------------------------------------------------------------------------------------------------
 * Bootcamp-30              25/08/2022        Oscar Candela           Realizar la creación de un método nuevo.
 */

package com.nttdata.bootcamp.bank.springboot.dao.inte;
import com.nttdata.bootcamp.bank.springboot.document.OperationActive;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

/**
 * Clase de interface dao para obtener los datos de la base de datos.
 */
public interface OperationActiveDaoInte extends ReactiveMongoRepository<OperationActive, String>{
    Mono<OperationActive> findByCodeOperationActive(String codeOperationActive);
}