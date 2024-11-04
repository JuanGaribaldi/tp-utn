package com.utn.supergym.services;

import com.utn.supergym.dtos.contrato.ContratoAltaRequest;
import com.utn.supergym.exceptions.AltaException;
import com.utn.supergym.repositories.ClienteRepository;
import com.utn.supergym.repositories.ContratoRepository;
import com.utn.supergym.utils.TestData;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ContratoServiceTest {

    private final ContratoRepository contratoRepository = Mockito.mock(ContratoRepository.class);

    private final ClienteRepository clienteRepository = Mockito.mock(ClienteRepository.class);

    private final PaseService paseService = Mockito.mock(PaseService.class);

    private final ContratoService contratoService = new ContratoService(contratoRepository, clienteRepository, paseService);

    @Test
    void darDeAltaContratoNuevoDaOk() {
        ContratoAltaRequest contratoAltaRequest = TestData.getContratoAltaRequest();
        when(clienteRepository.findById(contratoAltaRequest.getIdCliente())).thenReturn(Optional.of(TestData.getCliente()));
        when(paseService.configurarPase(contratoAltaRequest.getTipoPase(), contratoAltaRequest.getProductos())).thenReturn(TestData.getPase());
        assertDoesNotThrow(() -> contratoService.darDeAltaContrato(contratoAltaRequest));
    }

    @Test
    void darDeAltaContratoNoExisteClienteFalla() {
        ContratoAltaRequest contratoAltaRequest = TestData.getContratoAltaRequest();
        when(clienteRepository.findById(contratoAltaRequest.getIdCliente())).thenReturn(Optional.empty());
        Exception exception = assertThrows(AltaException.class, () -> contratoService.darDeAltaContrato(contratoAltaRequest));
        assertEquals(TestData.ERROR_EN_ALTA_CONTRATO + TestData.ERROR_CLIENTE_NO_ENCONTRADO, exception.getMessage());
    }

    @Test
    void consultarContrato() {
        //TODO
    }
}