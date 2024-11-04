package com.utn.supergym.services;

import com.utn.supergym.dtos.pagos.PagoResponse;
import com.utn.supergym.dtos.pase.PaseResponse;
import com.utn.supergym.entities.Pase;
import com.utn.supergym.entities.Producto;
import com.utn.supergym.entities.TipoPase;
import com.utn.supergym.repositories.PaseRepository;
import com.utn.supergym.utils.DateUtil;
import com.utn.supergym.utils.TestData;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class PaseServiceTest {

    private final PaseRepository paseRepository = Mockito.mock(PaseRepository.class);

    private final PaseService paseService = new PaseService(paseRepository);


    @Test
    void consultarPaseDaOk() {
        when(paseRepository.findById(TestData.ID)).thenReturn(Optional.of(TestData.getPase()));

        PaseResponse paseResponse = paseService.consultarPase(TestData.ID);

        assertEquals(TestData.ID, paseResponse.getId());
        assertTrue(TestData.TIPO_PASE.equalsIgnoreCase(paseResponse.getTipo()));

        List<String> productosAsociados = paseResponse.getProductosAsociados();
        assertNotNull(productosAsociados);
        assertEquals(2, productosAsociados.size());
        assertTrue(productosAsociados.contains(Producto.MUSCULACION.name()));
        assertTrue(productosAsociados.contains(Producto.PILETA.name()));

        assertEquals(DateUtil.toDateTimeString(TestData.FECHA), paseResponse.getFechaEmision());
        assertEquals(DateUtil.toDateTimeString(TestData.FECHA), paseResponse.getFechaProximoPago());

        List<PagoResponse> pagosRealizados = paseResponse.getPagosRealizados();
        assertNotNull(pagosRealizados);
        assertEquals(2, pagosRealizados.size());
        PagoResponse pago1 = pagosRealizados.get(0);
        assertEquals(TestData.ID, pago1.getId());
        assertEquals(DateUtil.toDateString(TestData.FECHA), pago1.getFechaPago());
        assertEquals(TestData.MONTO_PAGO, pago1.getMontoPago());

        PagoResponse pago2 = pagosRealizados.get(1);
        assertEquals(TestData.ID + 1, pago2.getId());
        assertEquals(DateUtil.toDateString(TestData.FECHA), pago2.getFechaPago());
        assertEquals(TestData.MONTO_PAGO, pago2.getMontoPago());
    }

    @Test
    void consultarPaseFalla() {
        when(paseRepository.findById(TestData.ID)).thenReturn(Optional.empty());

        Exception exception =
                assertThrows(NoSuchElementException.class, () -> paseService.consultarPase(TestData.ID));

        assertEquals("No existe el contrato solicitado.", exception.getMessage());
    }

    @Test
    void configurarPaseClassicDaOk() {
        String tipoPase = TestData.TIPO_PASE_CLASSIC;
        Pase pase = paseService.configurarPase(tipoPase, Collections.emptyList());

        assertNotNull(pase);
        assertNull(pase.getId());
        assertNull(pase.getCliente());
        assertNull(pase.getFechaEmision());
        assertNull(pase.getFechaProximoPago());
        assertNull(pase.getPagosRealizados());

        assertEquals(TipoPase.valueOf(tipoPase.toUpperCase().trim()), pase.getTipo());

        assertNotNull(pase.getProductosAsociados());
        assertEquals(1, pase.getProductosAsociados().size());
        assertTrue(pase.getProductosAsociados().contains(Producto.MUSCULACION));
    }

    @Test
    void configurarPasePlatinumDaOk() {
        String tipoPase = TestData.TIPO_PASE_PLATINUM;
        Pase pase = paseService.configurarPase(tipoPase, Collections.emptyList());

        assertNotNull(pase);
        assertNull(pase.getId());
        assertNull(pase.getCliente());
        assertNull(pase.getFechaEmision());
        assertNull(pase.getFechaProximoPago());
        assertNull(pase.getPagosRealizados());

        assertEquals(TipoPase.valueOf(tipoPase.toUpperCase().trim()), pase.getTipo());

        assertNotNull(pase.getProductosAsociados());
        assertEquals(3, pase.getProductosAsociados().size());
        assertTrue(pase.getProductosAsociados().contains(Producto.MUSCULACION));
        assertTrue(pase.getProductosAsociados().contains(Producto.PILETA));
        assertTrue(pase.getProductosAsociados().contains(Producto.CLASES));
    }

    @Test
    void configurarPaseBlackDaOk() {
        String tipoPase = TestData.TIPO_PASE_BLACK;
        List<String> productos = List.of(Producto.CLASES.name(), Producto.PILETA.name());
        Pase pase = paseService.configurarPase(tipoPase, productos);

        assertNotNull(pase);
        assertNull(pase.getId());
        assertNull(pase.getCliente());
        assertNull(pase.getFechaEmision());
        assertNull(pase.getFechaProximoPago());
        assertNull(pase.getPagosRealizados());

        assertEquals(TipoPase.valueOf(tipoPase.toUpperCase().trim()), pase.getTipo());

        assertNotNull(pase.getProductosAsociados());
        assertEquals(productos.size(), pase.getProductosAsociados().size());
        assertTrue(pase.getProductosAsociados().contains(Producto.PILETA));
        assertTrue(pase.getProductosAsociados().contains(Producto.CLASES));
    }
}