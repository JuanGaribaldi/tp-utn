package com.utn.supergym.services;

import com.utn.supergym.entities.Pase;
import com.utn.supergym.entities.Producto;
import com.utn.supergym.entities.TipoPase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaseService {
    public Pase configurarPase(String tipoPase, List<String> productos) {
        Pase pase = new Pase();
        pase.setTipo(TipoPase.valueOf(tipoPase.toUpperCase().trim()));
        if (TipoPase.PLATINUM.toString().equalsIgnoreCase(tipoPase.trim())) {
            pase.setProductosAsociados(List.of(Producto.CLASES, Producto.MUSCULACION, Producto.PILETA));
        } else if (TipoPase.CLASSIC.toString().equalsIgnoreCase(tipoPase.trim())) {
            pase.setProductosAsociados(List.of(Producto.MUSCULACION));
        } else {
            pase.setProductosAsociados(Producto.toProductos(productos));
        }
        return pase;
    }
}
