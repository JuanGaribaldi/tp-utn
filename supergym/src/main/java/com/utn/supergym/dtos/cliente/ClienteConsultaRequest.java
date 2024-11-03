package com.utn.supergym.dtos.cliente;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ClienteConsultaRequest {
    private String nombre;
    private String apellido;
    private Long dni;
    private Integer count;
    private Integer page;
}