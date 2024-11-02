package com.utn.supergym.dtos.response;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;


@Data
@Builder
public class PagoResponse {
    private Long id;
    private String fechaPago;
    private BigDecimal montoPago;
}
