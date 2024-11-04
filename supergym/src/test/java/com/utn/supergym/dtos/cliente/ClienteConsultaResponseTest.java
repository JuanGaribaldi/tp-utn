package com.utn.supergym.dtos.cliente;

import com.utn.supergym.entities.Cliente;
import com.utn.supergym.entities.EstadoUsuario;
import com.utn.supergym.utils.TestData;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteConsultaResponseTest {

    @Test
    void ejecutarFromRetornaUnClienteConsultaResponse() {
        Cliente cliente = TestData.getCliente();

        ClienteConsultaResponse clienteConsultaResponse = ClienteConsultaResponse.from(cliente);

        assertEquals(TestData.ID, clienteConsultaResponse.getId());
        assertEquals(TestData.NOMBRE_CLIENTE, clienteConsultaResponse.getNombre());
        assertEquals(TestData.APELLIDO_CLIENTE, clienteConsultaResponse.getApellido());
        assertEquals(TestData.DNI_CLIENTE, clienteConsultaResponse.getDni());
        assertEquals(EstadoUsuario.CREADO.toString(), clienteConsultaResponse.getEstadoUsuario());
    }
}