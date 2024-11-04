package com.utn.supergym.dtos.contrato;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.utn.supergym.dtos.cliente.ClienteConsultaResponse;
import com.utn.supergym.dtos.pase.PaseResponse;
import com.utn.supergym.entities.Contrato;
import com.utn.supergym.utils.DateUtil;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ContratoConsultaResponse {
    private Long id;
    private ClienteConsultaResponse cliente;
    private PaseResponse pase;
    private String fechaAlta;
    private BigDecimal monto;

    public static ContratoConsultaResponse from(Contrato contrato) {
        if (null == contrato) {
            return null;
        }
        return ContratoConsultaResponse.builder()
                .id(contrato.getId())
                .cliente(ClienteConsultaResponse.from(contrato.getCliente()))
                .pase(PaseResponse.from(contrato.getPase()))
                .fechaAlta(DateUtil.toDateString(contrato.getFechaAlta()))
                .monto(contrato.getMonto())
                .build();
    }
}