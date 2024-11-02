package com.utn.supergym.dtos.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClienteResponse {
    private Long id;
    private String nombre;
    private String apellido;
    private Long dni;
    private ContratoResponse contrato;
    private String estadoUsuario;
}
