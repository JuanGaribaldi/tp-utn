package com.utn.supergym.entities;

public enum EstadoUsuario {
    CREADO,
    HABILITADO,
    CON_DEUDA,
    DADO_DE_BAJA;

    public static EstadoUsuario toEstadoUsuario(String estado) {
        return EstadoUsuario.valueOf(estado.toUpperCase().trim());
    }
}
