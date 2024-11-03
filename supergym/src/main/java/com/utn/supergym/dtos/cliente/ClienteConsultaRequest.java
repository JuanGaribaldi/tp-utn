package com.utn.supergym.dtos.cliente;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClienteConsultaRequest {
    private String nombre;
    private String apellido;
    private Long dni;
    private Integer count;
    private Integer page;
}