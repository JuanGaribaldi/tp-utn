package com.utn.supergym.dtos.cliente;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.utn.supergym.dtos.contrato.ContratoConsultaResponse;
import com.utn.supergym.entities.Cliente;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ClienteResponse {
    private Long id;
    private String nombre;
    private String apellido;
    private Long dni;
    private ContratoConsultaResponse contrato;
    private String estadoUsuario;

    public static ClienteResponse from(Cliente cliente) {
        if (null == cliente) {
            return null;
        }
        return ClienteResponse.builder()
                .id(cliente.getId())
                .nombre(cliente.getNombre())
                .apellido(cliente.getApellido())
                .dni(cliente.getDni())
                .estadoUsuario(cliente.getEstadoUsuario().name())
                .build();
    }
}