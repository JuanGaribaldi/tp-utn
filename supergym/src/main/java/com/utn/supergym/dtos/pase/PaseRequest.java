package com.utn.supergym.dtos.pase;

import com.utn.supergym.dtos.pagos.PagoAltaRequest;
import com.utn.supergym.entities.Pase;
import com.utn.supergym.entities.Producto;
import com.utn.supergym.entities.TipoPase;
import com.utn.supergym.utils.DateUtil;
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
    private List<PagoAltaRequest> pagosRealizados;

    public Pase toPase() {
        Pase pase = new Pase();
        pase.setTipo(TipoPase.valueOf(tipo));
        pase.setProductosAsociados(toProductos());
        pase.setFechaEmision(fechaEmision != null ? DateUtil.parseLocalDateTime(fechaEmision) : null);
        pase.setFechaProximoPago(fechaProximoPago != null ? DateUtil.parseLocalDateTime(fechaProximoPago) : null);
        return pase;
    }

    private List<Producto> toProductos() {
        return productosAsociados.stream().map(this::toProducto).toList();
    }

    private Producto toProducto(String producto) {
        return Producto.valueOf(producto);
    }
}