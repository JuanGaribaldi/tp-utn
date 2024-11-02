package com.utn.supergym.dtos.request;

import com.utn.supergym.entities.Contrato;
import com.utn.supergym.utils.DateUtil;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
        contrato.setFechaAlta(fechaAlta != null ? DateUtil.parseLocalDateTime(fechaAlta): null); //TODO
        contrato.setMonto(monto);
        return contrato;
    }
}
