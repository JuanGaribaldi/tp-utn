package com.utn.supergym.dtos.request;

import com.utn.supergym.entities.Contrato;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ContratoRequest {
    private ClienteRequest cliente;
    private PaseRequest pase;
    private String fechaAlta;
    private BigDecimal monto;

    public Contrato toContrato() {
        Contrato contrato = new Contrato();
        contrato.setCliente(cliente.toCliente());
        contrato.setPase(pase.toPase());
        contrato.setFechaAlta(null); //TODO
        contrato.setMonto(monto);
        return contrato;
    }
}
