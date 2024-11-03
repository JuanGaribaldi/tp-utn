package com.utn.supergym.dtos.contrato;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.utn.supergym.dtos.cliente.ClienteConsultaResponse;
import com.utn.supergym.dtos.pase.PaseResponse;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ContratoResponse {
    private Long id;
    private ClienteConsultaResponse cliente;
    private PaseResponse pase;
    private String fechaAlta;
    private BigDecimal monto;
}