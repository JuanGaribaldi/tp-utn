package com.utn.supergym.dtos.request;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;


@Data
@Builder
public class PagoRequest {
    private Long id;
    private String fechaPago;
    private BigDecimal montoPago;
}
