package com.utn.supergym.dtos.request;

import com.utn.supergym.entities.Pase;
import com.utn.supergym.entities.Producto;
import com.utn.supergym.entities.TipoPase;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PaseRequest {
    private String tipo;
    private List<String> productosAsociados;
    private String fechaEmision;
    private String fechaProximoPago;
    private List<PagoRequest> pagosRealizados;

    public Pase toPase() {
        Pase pase = new Pase();
        pase.setTipo(TipoPase.valueOf(tipo));
        pase.setProductosAsociados(toProductos());
        pase.setFechaEmision(null); //TODO
        pase.setFechaProximoPago(null); //TODO
        return pase;
    }

    private List<Producto> toProductos() {
        return productosAsociados.stream().map(this::toProducto).toList();
    }

    private Producto toProducto(String producto) {
        return Producto.valueOf(producto);
    }
}
