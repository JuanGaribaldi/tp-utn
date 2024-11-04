package com.utn.supergym.dtos.pagos;

import com.utn.supergym.entities.Pago;
import com.utn.supergym.utils.DateUtil;
import com.utn.supergym.utils.TestData;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PagoResponseTest {

    @Test
    void ejecutarFromPagoRetornaPago() {
        Pago pago = TestData.getPago(TestData.ID);
        PagoResponse pagoResponse = PagoResponse.fromPago(pago);

        assertEquals(TestData.ID, pagoResponse.getId());
        assertEquals(DateUtil.toDateString(TestData.FECHA), pagoResponse.getFechaPago());
        assertEquals(BigDecimal.TEN, pagoResponse.getMontoPago());
    }
}