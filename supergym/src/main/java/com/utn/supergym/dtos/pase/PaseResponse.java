package com.utn.supergym.dtos.pase;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.utn.supergym.dtos.pagos.PagoResponse;
import com.utn.supergym.entities.Pase;
import com.utn.supergym.entities.Producto;
import com.utn.supergym.utils.DateUtil;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PaseResponse {
    private Long id;
    private String tipo;
    private List<String> productosAsociados;
    private String fechaEmision;
    private String fechaProximoPago;
    private List<PagoResponse> pagosRealizados;

    public static PaseResponse from(Pase pase) {
        return PaseResponse.builder()
                .id(pase.getId())
                .tipo(pase.getTipo().name())
                .productosAsociados(pase.getProductosAsociados().stream().map(Producto::name).toList())
                .fechaEmision(DateUtil.toDateTimeString(pase.getFechaEmision()))
                .fechaProximoPago(DateUtil.toDateTimeString(pase.getFechaProximoPago()))
                .pagosRealizados(pase.getPagosRealizados().stream().map(PagoResponse::fromPago).toList())
                .build();
    }
}