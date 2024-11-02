package com.utn.supergym.dtos.alta.response;

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
