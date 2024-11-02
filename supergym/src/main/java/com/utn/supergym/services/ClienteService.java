package com.utn.supergym.services;

import com.utn.supergym.dtos.alta.request.ClienteRequest;
import com.utn.supergym.entities.Cliente;
import com.utn.supergym.repositories.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public void darDeAltaCliente(ClienteRequest clienteRequest) {
        Cliente cliente = clienteRequest.toCliente();
        clienteRepository.save(cliente);
    }
}
