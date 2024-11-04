package com.utn.supergym.services;

import com.utn.supergym.dtos.cliente.ClienteAltaRequest;
import com.utn.supergym.dtos.cliente.ClienteResponse;
import com.utn.supergym.dtos.cliente.ClienteUpdateRequest;
import com.utn.supergym.entities.Cliente;
import com.utn.supergym.entities.EstadoUsuario;
import com.utn.supergym.exceptions.AltaException;
import com.utn.supergym.repositories.ClienteRepository;
import com.utn.supergym.utils.TestData;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


class ClienteServiceTest {

    private final ClienteRepository clienteRepository = Mockito.mock(ClienteRepository.class);

    private final ClienteService clienteService = new ClienteService(clienteRepository);


    @Test
    void darDeAltaClienteNuevoDaOk() {
        ClienteAltaRequest clienteAltaRequest = TestData.getClienteAltaRequest();
        Cliente esperado = TestData.getCliente();

        when(clienteRepository.findByDni(TestData.DNI_CLIENTE)).thenReturn(Optional.empty());
        when(clienteRepository.save(ArgumentMatchers.any())).thenReturn(TestData.getCliente());

        ClienteResponse clienteResponse =
                assertDoesNotThrow((() -> clienteService.darDeAltaCliente(clienteAltaRequest)));

        assertEquals(esperado.getId(), clienteResponse.getId());
        assertEquals(esperado.getEstadoUsuario().name(), clienteResponse.getEstadoUsuario());
        assertEquals(esperado.getNombre(), clienteResponse.getNombre());
        assertEquals(esperado.getApellido(), clienteResponse.getApellido());
        assertEquals(esperado.getDni(), clienteResponse.getDni());
        assertNull(clienteResponse.getContrato());
        assertEquals(esperado.getEstadoUsuario().name(), clienteResponse.getEstadoUsuario());
    }

    @Test
    void darDeAltaClienteExistenteFalla() {
        ClienteAltaRequest clienteAltaRequest = TestData.getClienteAltaRequest();

        when(clienteRepository.findByDni(TestData.DNI_CLIENTE)).thenReturn(Optional.of(TestData.getCliente()));

        Exception exception =
                assertThrows(AltaException.class, () -> clienteService.darDeAltaCliente(clienteAltaRequest));

        assertTrue(exception.getMessage().contains(TestData.ERROR_CLIENTE_EXISTENTE));
    }

    @Test
    void consultarClienteEncuentraDatos() {
        Long idCliente = TestData.ID;
        Cliente esperado = TestData.getCliente();

        when(clienteRepository.findById(TestData.ID)).thenReturn(Optional.of(TestData.getCliente()));

        ClienteResponse clienteResponse = assertDoesNotThrow((() -> clienteService.consultarCliente(idCliente)));

        assertEquals(esperado.getId(), clienteResponse.getId());
        assertEquals(esperado.getEstadoUsuario().name(), clienteResponse.getEstadoUsuario());
        assertEquals(esperado.getNombre(), clienteResponse.getNombre());
        assertEquals(esperado.getApellido(), clienteResponse.getApellido());
        assertEquals(esperado.getDni(), clienteResponse.getDni());
        assertNull(clienteResponse.getContrato());
        assertEquals(esperado.getEstadoUsuario().name(), clienteResponse.getEstadoUsuario());
    }

    @Test
    void consultarClienteNoEncuentraDatos() {
        Long idCliente = TestData.ID;

        when(clienteRepository.findById(TestData.ID)).thenReturn(Optional.empty());

        Exception exception =
                assertThrows(NoSuchElementException.class, () -> clienteService.consultarCliente(idCliente));
        assertTrue(exception.getMessage().contains(TestData.ERROR_CLIENTE_NO_ENCONTRADO));
    }

    @Test
    void actualizarEstadoEncuentraDatosParaActualizar() {

        ClienteUpdateRequest clienteUpdateRequest = TestData.getClienteUpdateRequest();
        Cliente esperado = TestData.getCliente();
        esperado.setEstadoUsuario(EstadoUsuario.HABILITADO);

        Cliente obtenido = TestData.getCliente();
        when(clienteRepository.findById(clienteUpdateRequest.getIdCliente())).thenReturn(Optional.of(obtenido));

        obtenido.setEstadoUsuario(EstadoUsuario.HABILITADO);
        when(clienteRepository.save(ArgumentMatchers.any())).thenReturn(obtenido);

        ClienteResponse clienteResponse =
                assertDoesNotThrow(() -> clienteService.actualizarEstado(clienteUpdateRequest));

        assertEquals(esperado.getEstadoUsuario().name(), clienteResponse.getEstadoUsuario());
        assertEquals(esperado.getNombre(), clienteResponse.getNombre());
        assertEquals(esperado.getApellido(), clienteResponse.getApellido());
        assertEquals(esperado.getDni(), clienteResponse.getDni());
        assertNull(clienteResponse.getContrato());
        assertEquals(esperado.getEstadoUsuario().name(), clienteResponse.getEstadoUsuario());

    }

    @Test
    void actualizarEstadoNoEncuentraDatosParaActualizar() {

        ClienteUpdateRequest clienteUpdateRequest = TestData.getClienteUpdateRequest();
        Cliente esperado = TestData.getCliente();
        esperado.setEstadoUsuario(EstadoUsuario.HABILITADO);

        when(clienteRepository.findById(clienteUpdateRequest.getIdCliente())).thenReturn(Optional.empty());

        Exception exception =
                assertThrows(NoSuchElementException.class, () -> clienteService.actualizarEstado(clienteUpdateRequest));

        assertTrue(exception.getMessage().contains(TestData.ERROR_CLIENTE_NO_ENCONTRADO));

    }
}