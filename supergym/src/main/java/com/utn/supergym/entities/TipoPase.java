package com.utn.supergym.entities;

import ch.qos.logback.core.util.StringUtil;

import java.util.Arrays;

public enum TipoPase {
    CLASSIC,
    BLACK,
    PLATINUM;

    public static boolean esTipoPaseValido(String valor) {
        if (StringUtil.isNullOrEmpty(valor)) {
            return false;
        }
        return Arrays.stream(values()).anyMatch(e -> e.toString().equalsIgnoreCase(valor.trim()));
    }
}
