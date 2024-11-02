package com.utn.supergym.entities;

import java.util.Arrays;

public enum TipoPase {
    CLASSIC,
    BLACK,
    PLATINUM;

    public static boolean esTipoPaseValido(String valor) {
        return Arrays.stream(values()).anyMatch(e -> e.toString().equalsIgnoreCase(valor.trim()));
    }
}
