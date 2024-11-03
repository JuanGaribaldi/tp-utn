package com.utn.supergym.entities;

import jakarta.validation.constraints.NotEmpty;

import java.util.Arrays;
import java.util.List;

public enum Producto {
    MUSCULACION,
    CLASES,
    PILETA;

    public static boolean sonProductosValidos(@NotEmpty List<String> productos) {
        return productos.stream().allMatch(Producto::esProductoValido);
    }

    private static boolean esProductoValido(String producto) {
        return Arrays.stream(values()).anyMatch(e -> e.toString().equalsIgnoreCase(producto.trim()));
    }

    public static List<Producto> toProductos(List<String> productos) {
        return productos.stream().map(Producto::toProducto).toList();
    }

    public static Producto toProducto(String producto) {
        return Producto.valueOf(producto.toUpperCase().trim());
    }
}
