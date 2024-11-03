package com.utn.supergym.services;

import com.utn.supergym.dtos.pagos.PagoAltaRequest;
import com.utn.supergym.entities.Pago;
import com.utn.supergym.entities.Pase;
import com.utn.supergym.exceptions.AltaException;
import com.utn.supergym.repositories.PagoRepository;
import com.utn.supergym.repositories.PaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PagoService {

    @Autowired
    private PagoRepository pagoRepository;

    @Autowired
    private PaseRepository paseRepository;

    public Pago darDeAltaPago(PagoAltaRequest pagoAltaRequest) throws AltaException {
        Pago pago = pagoAltaRequest.toPago();

        Optional<Pase> pase = paseRepository.findById(pagoAltaRequest.getIdPase());

        if (pase.isEmpty()) {
            throw new AltaException("Error en alta de Pago : no se encontró Pase para el ID de Cliente informado");
        }
        Pase paseEntity = pase.get();

        pago.setFechaPago(paseEntity.getFechaProximoPago().plusMonths(1));
        paseEntity.addPagoRealizado(pago);

        paseRepository.save(paseEntity);

        return pago;
    }
}
