package com.utn.supergym.dtos.request;

import com.utn.supergym.entities.Contrato;
import com.utn.supergym.entities.Pago;
import com.utn.supergym.utils.DateUtil;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;


@Data
@Builder
public class PagoRequest {
    private Long id;
    private String fechaPago;
    private BigDecimal montoPago;

    public Pago toPago() {
        Pago pago = new Pago();
        pago.setFechaPago(DateUtil.parseLocalDateTime(fechaPago));
        pago.setMontoPago(montoPago);
        return pago;
    }

}
