package com.utn.supergym.dtos.contrato;

import com.utn.supergym.dtos.cliente.ClienteResponse;
import com.utn.supergym.dtos.pase.PaseResponse;
import com.utn.supergym.entities.Contrato;
import com.utn.supergym.utils.DateUtil;
import com.utn.supergym.utils.TestData;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ContratoConsultaResponseTest {

    @Test
    void ejecutarFromRetornaContratoConsultaResponse() {
        Contrato contrato = TestData.getContrato();
        ContratoConsultaResponse contratoConsultaResponse = ContratoConsultaResponse.from(contrato);

        assertEquals(TestData.ID, contratoConsultaResponse.getId());
        assertEquals(ClienteResponse.from(contrato.getCliente()), contratoConsultaResponse.getCliente());
        assertEquals(PaseResponse.from(contrato.getPase()), contratoConsultaResponse.getPase());
        assertEquals(DateUtil.toDateString(TestData.FECHA), contratoConsultaResponse.getFechaAlta());
        assertEquals(BigDecimal.TEN, contratoConsultaResponse.getMonto());
    }
}