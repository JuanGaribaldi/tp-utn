package com.utn.supergym.dtos.response;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ContratoResponse {
    private Long id;
    private ClienteResponse cliente;
    private PaseResponse pase;
    private String fechaAlta;
    private BigDecimal monto;

}
