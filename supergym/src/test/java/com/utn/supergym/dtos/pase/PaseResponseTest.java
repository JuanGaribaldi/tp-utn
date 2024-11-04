package com.utn.supergym.dtos.pase;

import com.utn.supergym.entities.Pase;
import com.utn.supergym.utils.DateUtil;
import com.utn.supergym.utils.TestData;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PaseResponseTest {

    @Test
    void ejecutarFromDevuelvePase() {
        Pase pase = TestData.getPase();

        PaseResponse paseResponse = PaseResponse.from(pase);
        assertEquals(TestData.ID, paseResponse.getId());
        assertTrue(TestData.TIPO_PASE.equalsIgnoreCase(paseResponse.getTipo()));
        assertTrue(TestData.PRODUCTO_MUSCULACION.equalsIgnoreCase(paseResponse.getProductosAsociados().get(0)));
        assertTrue(TestData.PRODUCTO_PILETA.equalsIgnoreCase(paseResponse.getProductosAsociados().get(1)));
        assertEquals(DateUtil.toDateTimeString(TestData.FECHA), paseResponse.getFechaEmision());
        assertEquals(DateUtil.toDateTimeString(TestData.FECHA), paseResponse.getFechaProximoPago());
        assertEquals(TestData.ID, paseResponse.getPagosRealizados().get(0).getId());
        assertEquals(BigDecimal.TEN, paseResponse.getPagosRealizados().get(0).getMontoPago());
        assertEquals(DateUtil.toDateString(TestData.FECHA), paseResponse.getPagosRealizados().get(0).getFechaPago());
        assertEquals(TestData.ID + 1, paseResponse.getPagosRealizados().get(1).getId());
        assertEquals(BigDecimal.TEN, paseResponse.getPagosRealizados().get(1).getMontoPago());
        assertEquals(DateUtil.toDateString(TestData.FECHA), paseResponse.getPagosRealizados().get(1).getFechaPago());
    }
}