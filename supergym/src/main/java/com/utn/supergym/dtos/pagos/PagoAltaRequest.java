package com.utn.supergym.dtos.pagos;

import com.utn.supergym.entities.Pago;
import com.utn.supergym.utils.DateUtil;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Data
@Builder
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