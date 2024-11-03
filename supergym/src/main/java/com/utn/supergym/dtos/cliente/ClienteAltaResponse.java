package com.utn.supergym.dtos.cliente;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.utn.supergym.dtos.contrato.ContratoResponse;
import com.utn.supergym.entities.Cliente;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ClienteAltaResponse {
    private Long id;
    private String nombre;
    private String apellido;
    private Long dni;
    private ContratoResponse contrato;
    private String estadoUsuario;

    public static ClienteAltaResponse from(Cliente cliente) {
        return ClienteAltaResponse.builder()
                .id(cliente.getId())
                .nombre(cliente.getNombre())
                .apellido(cliente.getApellido())
                .dni(cliente.getDni())
                .build();
    }
}