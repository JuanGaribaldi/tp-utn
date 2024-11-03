package com.utn.supergym.dtos.pagos;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.utn.supergym.entities.Pago;
import com.utn.supergym.utils.DateUtil;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;


@Data
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PagoResponse {
    private Long id;
    private String fechaPago;
    private BigDecimal montoPago;

    public static PagoResponse fromPago(Pago pago) {
        return PagoResponse.builder()
                .id(pago.getId())
                .fechaPago(DateUtil.toDateString(pago.getFechaPago()))
                .montoPago(pago.getMontoPago())
                .build();
    }
}