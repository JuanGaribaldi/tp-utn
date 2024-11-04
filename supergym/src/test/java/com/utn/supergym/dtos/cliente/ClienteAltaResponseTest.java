package com.utn.supergym.dtos.cliente;

import com.utn.supergym.entities.Cliente;
import com.utn.supergym.utils.TestData;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClienteAltaResponseTest {

    @Test
    void ejecutarFromRetornaUnClienteAltaResponse() {
        Cliente cliente = TestData.getCliente();

        ClienteAltaResponse clienteAltaResponse = ClienteAltaResponse.from(cliente);

        assertEquals(TestData.ID, clienteAltaResponse.getId());
        assertEquals(TestData.NOMBRE_CLIENTE, clienteAltaResponse.getNombre());
        assertEquals(TestData.APELLIDO_CLIENTE, clienteAltaResponse.getApellido());
        assertEquals(TestData.DNI_CLIENTE, clienteAltaResponse.getDni());
    }
}