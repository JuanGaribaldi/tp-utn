package com.utn.supergym.dtos.contrato;

import com.utn.supergym.entities.Contrato;
import com.utn.supergym.utils.TestData;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ContratoAltaRequestTest {

    @Test
    void ejecutarToContratoRetornaContrato() {
        ContratoAltaRequest contratoAltaRequest = TestData.getContratoAltaRequest();
        Contrato contrato = contratoAltaRequest.toContrato();
        assertEquals(BigDecimal.TEN, contrato.getMonto());
        assertNull(contrato.getId());
        assertNull(contrato.getPase());
        assertNull(contrato.getFechaAlta());
        assertNull(contrato.getCliente());
    }
}