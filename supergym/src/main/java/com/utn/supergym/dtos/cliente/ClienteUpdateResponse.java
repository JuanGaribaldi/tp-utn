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
public class ClienteUpdateResponse {
    private Long id;
    private String nombre;
    private String apellido;
    private Long dni;
    private ContratoConsultaResponse contrato;
    private String estadoUsuario;

    public static ClienteUpdateResponse from(Cliente cliente) {
        return ClienteUpdateResponse.builder()
                .id(cliente.getId())
                .nombre(cliente.getNombre())
                .apellido(cliente.getApellido())
                .dni(cliente.getDni())
                .contrato(ContratoConsultaResponse.from(cliente.getContrato()))
                .estadoUsuario(cliente.getEstadoUsuario().name())
                .build();
    }
}