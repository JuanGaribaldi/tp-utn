package com.utn.supergym.dtos.cliente;

import com.utn.supergym.entities.Cliente;
import com.utn.supergym.entities.EstadoUsuario;
import com.utn.supergym.utils.TestData;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteResponseTest {

    @Test
    void ejecutarFromRetornaUnClienteConsultaResponse() {
        Cliente cliente = TestData.getCliente();

        ClienteResponse clienteResponse = ClienteResponse.from(cliente);

        assertEquals(TestData.ID, clienteResponse.getId());
        assertEquals(TestData.NOMBRE_CLIENTE, clienteResponse.getNombre());
        assertEquals(TestData.APELLIDO_CLIENTE, clienteResponse.getApellido());
        assertEquals(TestData.DNI_CLIENTE, clienteResponse.getDni());
        assertEquals(EstadoUsuario.CREADO.toString(), clienteResponse.getEstadoUsuario());
    }
}