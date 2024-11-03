package com.utn.supergym.utils;

import com.utn.supergym.dtos.cliente.ClienteAltaRequest;

public class TestData {

    public static final Long DNI_CLIENTE = 123456789L;
    public static final String NOMBRE_CLIENTE = "Bruno";
    public static final String APELLIDO_CLIENTE = "Diaz";

    public static ClienteAltaRequest getClienteAltaRequest() {
        return ClienteAltaRequest.builder()
                .nombre(NOMBRE_CLIENTE)
                .apellido(APELLIDO_CLIENTE)
                .dni(DNI_CLIENTE)
                .build();
    }
}
