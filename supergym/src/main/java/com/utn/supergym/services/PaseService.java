package com.utn.supergym.services;

import com.utn.supergym.dtos.pase.PaseResponse;
import com.utn.supergym.entities.Pase;
import com.utn.supergym.entities.Producto;
import com.utn.supergym.entities.TipoPase;
import com.utn.supergym.repositories.PaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PaseService {

    @Autowired
    private PaseRepository paseRepository;

    public PaseResponse consultarPase(Long idPase) {
        Optional<Pase> pase = paseRepository.findById(idPase);
        if (pase.isEmpty()) {
            throw new NoSuchElementException("No existe el contrato solicitado.");
        }

        return PaseResponse.from(pase.get());
    }

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
