package com.utn.supergym.dtos.pagos;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.utn.supergym.entities.Pago;
import com.utn.supergym.utils.DateUtil;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Data
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PagoAltaRequest {
    private Long idPase;
    private String fechaPago;
    private BigDecimal montoPago;

    public Pago toPago() {
        Pago pago = new Pago();
        pago.setFechaPago(fechaPago != null ? DateUtil.parseLocalDateTime(fechaPago) : LocalDateTime.now());
        pago.setMontoPago(montoPago);
        return pago;
    }
}