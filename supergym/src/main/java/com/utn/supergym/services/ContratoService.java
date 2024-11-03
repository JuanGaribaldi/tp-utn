package com.utn.supergym.services;

import com.utn.supergym.dtos.contrato.ContratoRequest;
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

    public void darDeAltaContrato(ContratoRequest contratoRequest) throws AltaException {
        try {
            Optional<Cliente> cliente = clienteRepository.findById(contratoRequest.getIdCliente());
            if (cliente.isEmpty()) {
                throw new NoSuchElementException("No existe el cliente solicitado.");
            }
            Pase pase = paseService.configurarPase(contratoRequest.getTipoPase(), contratoRequest.getProductos());
            Contrato contrato = contratoRequest.toContrato();
            contrato.setCliente(cliente.get());
            contrato.setPase(pase);
            contratoRepository.save(contrato);
        } catch (NoSuchElementException e) {
            throw new AltaException("Error en alta contrato: " + e.getMessage());
        }
    }
}
