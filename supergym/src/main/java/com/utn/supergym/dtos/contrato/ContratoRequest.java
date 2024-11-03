package com.utn.supergym.dtos.contrato;

import com.utn.supergym.entities.Contrato;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class ContratoRequest {
    @NotEmpty
    private Long idCliente;
    @NotEmpty
    private BigDecimal monto;
    @NotEmpty
    private String tipoPase;
    private List<String> productos;

    public Contrato toContrato() {
        Contrato contrato = new Contrato();
        contrato.setMonto(monto);
        return contrato;
    }
}