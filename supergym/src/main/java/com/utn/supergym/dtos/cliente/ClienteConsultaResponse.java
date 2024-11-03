package com.utn.supergym.dtos.cliente;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.utn.supergym.dtos.contrato.ContratoResponse;
import com.utn.supergym.entities.Cliente;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ClienteConsultaResponse {
    private Long id;
    private String nombre;
    private String apellido;
    private Long dni;
    private ContratoResponse contrato;
    private String estadoUsuario;

    public static ClienteConsultaResponse from(Cliente cliente) {
        return ClienteConsultaResponse.builder()
                .id(cliente.getId())
                .nombre(cliente.getNombre())
                .apellido(cliente.getApellido())
                .dni(cliente.getDni())
                .build();
    }
}