package com.utn.supergym.dtos.pagos;

import com.utn.supergym.entities.Pago;
import com.utn.supergym.utils.TestData;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PagoAltaRequestTest {

    @Test
    void ejecutarToPagoRetornaPago() {
        PagoAltaRequest pagoAltaRequest = TestData.getPagoAltaRequest();
        Pago pago = pagoAltaRequest.toPago();
        assertTrue(TestData.FECHA.isEqual(pago.getFechaPago()));
        assertEquals(BigDecimal.TEN, pago.getMontoPago());
    }
}