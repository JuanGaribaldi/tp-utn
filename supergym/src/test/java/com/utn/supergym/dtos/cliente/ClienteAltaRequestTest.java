package com.utn.supergym.dtos.cliente;

import com.utn.supergym.entities.Cliente;
import com.utn.supergym.utils.TestData;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClienteAltaRequestTest {

    @Test
    void ejecutarToClienteRetornaUnCliente() {
        ClienteAltaRequest request = TestData.getClienteAltaRequest();
        Cliente cliente = request.toCliente();
        assertEquals(TestData.NOMBRE_CLIENTE, cliente.getNombre());
        assertEquals(TestData.APELLIDO_CLIENTE, cliente.getApellido());
        assertEquals(TestData.DNI_CLIENTE, cliente.getDni());
    }
}