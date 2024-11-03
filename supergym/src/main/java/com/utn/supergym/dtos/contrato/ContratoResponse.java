package com.utn.supergym.dtos.contrato;

import com.utn.supergym.dtos.cliente.ClienteConsultaResponse;
import com.utn.supergym.dtos.pase.PaseResponse;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ContratoResponse {
    private Long id;
    private ClienteConsultaResponse cliente;
    private PaseResponse pase;
    private String fechaAlta;
    private BigDecimal monto;
}