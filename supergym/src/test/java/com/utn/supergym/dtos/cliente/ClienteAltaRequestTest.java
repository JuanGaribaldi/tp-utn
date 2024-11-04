package com.utn.supergym.dtos.cliente;

import com.utn.supergym.entities.Cliente;
import com.utn.supergym.entities.EstadoUsuario;
import com.utn.supergym.utils.TestData;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClienteAltaRequestTest {

    @Test
    void ejecutarToClienteRetornaUnCliente() {
        ClienteAltaRequest clienteAltaRequest = TestData.getClienteAltaRequest();
        Cliente clienteObtenido = clienteAltaRequest.toCliente();

        assertEquals(TestData.NOMBRE_CLIENTE, clienteObtenido.getNombre());
        assertEquals(TestData.APELLIDO_CLIENTE, clienteObtenido.getApellido());
        assertEquals(TestData.DNI_CLIENTE, clienteObtenido.getDni());
        assertEquals(EstadoUsuario.CREADO, clienteObtenido.getEstadoUsuario());
    }
}