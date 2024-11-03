package com.utn.supergym.dtos.pase;

import com.utn.supergym.dtos.pagos.PagoResponse;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PaseResponse {
    private Long id;
    private String tipo;
    private List<String> productosAsociados;
    private String fechaEmision;
    private String fechaProximoPago;
    private List<PagoResponse> pagosRealizados;
}