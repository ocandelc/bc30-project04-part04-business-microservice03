/**
 * Resumen.
 * Objeto                   : OperationActiveDetail.java
 * Descripción              : Clase de tipo document para obtener o establecer los datos de cada atributo.
 * Fecha de Creación        : 24/08/2022.
 * Proyecto de Creación     : Bootcamp-30.
 * Autor                    : Mario Vásquez.
 * ---------------------------------------------------------------------------------------------------------------------------
 * Modificaciones
 * Motivo                   Fecha             Nombre                  Descripción
 * ---------------------------------------------------------------------------------------------------------------------------
 * Bootcamp-30              25/08/2022        Oscar Candela           Modificación de un campo.
 */
package com.nttdata.bootcamp.bank.springboot.document;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * Clase de tipo document para obtener o establecer los datos de cada atributo.
 */
@Data
@AllArgsConstructor
@Document(collection="operation_active_detail")
public class OperationActiveDetail {
    @Id
    private String id;
    private String state;
    private String codeOperationType;
    private Double amountPayable;
    private Double capital;
    private String codeLocation;
    private Date dateAccountStatus;
    private Double interest;
    private Date lastDayForPayment;
    private String codeOperationActive;
    private String codeOperationActiveDetail;
    private String paymentNumber;
    private String codeCustomerPaying;
}