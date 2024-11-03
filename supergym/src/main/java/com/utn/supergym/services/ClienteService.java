package com.utn.supergym.services;

import com.utn.supergym.dtos.cliente.ClienteAltaRequest;
import com.utn.supergym.dtos.cliente.ClienteAltaResponse;
import com.utn.supergym.dtos.cliente.ClienteConsultaResponse;
import com.utn.supergym.entities.Cliente;
import com.utn.supergym.exceptions.AltaException;
import com.utn.supergym.repositories.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteAltaResponse darDeAltaCliente(ClienteAltaRequest clienteAltaRequest) throws AltaException {
        validarExistenciaCliente(clienteAltaRequest);
        Cliente cliente = clienteRepository.save(clienteAltaRequest.toCliente());
        return ClienteAltaResponse.from(cliente);
    }

    private void validarExistenciaCliente(ClienteAltaRequest clienteAltaRequest) throws AltaException {
        Optional<Cliente> clienteAValidar = clienteRepository.findByDni(clienteAltaRequest.getDni());
        if (clienteAValidar.isPresent()) {
            throw new AltaException("El cliente ya existe en el sistema.");
        }
    }

    public ClienteConsultaResponse consultarCliente(Long idCliente) {
        Optional<Cliente> cliente = clienteRepository.findById(idCliente);
        if (cliente.isEmpty()) {
            throw new NoSuchElementException("No se encontró el cliente con id: " + idCliente);
        }
        return ClienteConsultaResponse.from(cliente.get());
    }
}
