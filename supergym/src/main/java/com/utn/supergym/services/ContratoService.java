package com.utn.supergym.services;

import com.utn.supergym.dtos.contrato.ContratoAltaRequest;
import com.utn.supergym.dtos.contrato.ContratoConsultaResponse;
import com.utn.supergym.entities.Cliente;
import com.utn.supergym.entities.Contrato;
import com.utn.supergym.entities.Pase;
import com.utn.supergym.exceptions.AltaException;
import com.utn.supergym.repositories.ClienteRepository;
import com.utn.supergym.repositories.ContratoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContratoService {
    private final ContratoRepository contratoRepository;
    private final ClienteRepository clienteRepository;
    private final PaseService paseService;

    public void darDeAltaContrato(ContratoAltaRequest contratoAltaRequest) throws AltaException {
        try {
            Optional<Cliente> cliente = clienteRepository.findById(contratoAltaRequest.getIdCliente());
            if (cliente.isEmpty()) {
                throw new NoSuchElementException("No se encontró el cliente con id: " + contratoAltaRequest.getIdCliente());
            }
            Pase pase = paseService.configurarPase(contratoAltaRequest.getTipoPase(), contratoAltaRequest.getProductos());
            pase.setCliente(cliente.get());

            Contrato contrato = contratoAltaRequest.toContrato();
            contrato.setCliente(cliente.get());
            contrato.setPase(pase);

            cliente.get().setContrato(contrato);

            contratoRepository.save(contrato);
        } catch (NoSuchElementException e) {
            throw new AltaException("Error en alta contrato: " + e.getMessage());
        }
    }

    public ContratoConsultaResponse consultarContrato(Long idContrato) throws NoSuchElementException {
        Optional<Contrato> contrato = contratoRepository.findById(idContrato);
        if (contrato.isEmpty()) {
            throw new NoSuchElementException("No existe el contrato solicitado.");
        }

        Contrato contratoEntity = contrato.get();
        return ContratoConsultaResponse.from(contratoEntity);
    }
}
