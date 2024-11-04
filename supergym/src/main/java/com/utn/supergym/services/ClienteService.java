package com.utn.supergym.services;

import com.utn.supergym.dtos.cliente.ClienteAltaRequest;
import com.utn.supergym.dtos.cliente.ClienteResponse;
import com.utn.supergym.dtos.cliente.ClienteUpdateRequest;
import com.utn.supergym.entities.Cliente;
import com.utn.supergym.entities.EstadoUsuario;
import com.utn.supergym.exceptions.AltaException;
import com.utn.supergym.repositories.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteResponse darDeAltaCliente(ClienteAltaRequest clienteAltaRequest) throws AltaException {
        validarExistenciaCliente(clienteAltaRequest);
        Cliente cliente = clienteRepository.save(clienteAltaRequest.toCliente());
        return ClienteResponse.from(cliente);
    }

    private void validarExistenciaCliente(ClienteAltaRequest clienteAltaRequest) throws AltaException {
        Optional<Cliente> clienteAValidar = clienteRepository.findByDni(clienteAltaRequest.getDni());
        if (clienteAValidar.isPresent()) {
            throw new AltaException("El cliente ya existe en el sistema.");
        }
    }

    private Cliente validarExistenciaYObtenerCliente(ClienteUpdateRequest clienteUpdateRequest) throws BadRequestException {
        Long idCliente = clienteUpdateRequest.getIdCliente();
        if (null == idCliente) {
            throw new BadRequestException("Debe informarse el ID del cliente a actualizar estado.");
        }
        String estadoUsuario = clienteUpdateRequest.getEstadoUsuario();
        if (null == estadoUsuario) {
            throw new BadRequestException("Debe informarse el nuevo valor de estado usuario.");
        }

        Optional<Cliente> clienteAValidar = clienteRepository.findById(idCliente);
        if (clienteAValidar.isEmpty()) {
            throw new NoSuchElementException("No se encontró el cliente con id: " + idCliente);
        }
        return clienteAValidar.get();
    }

    public ClienteResponse consultarCliente(Long idCliente) {
        Optional<Cliente> cliente = clienteRepository.findById(idCliente);
        if (cliente.isEmpty()) {
            throw new NoSuchElementException("No se encontró el cliente con id: " + idCliente);
        }
        return ClienteResponse.from(cliente.get());
    }

    public ClienteResponse actualizarEstado(ClienteUpdateRequest clienteUpdateRequest) throws BadRequestException {
        Cliente cliente = validarExistenciaYObtenerCliente(clienteUpdateRequest);
        cliente.setEstadoUsuario(EstadoUsuario.toEstadoUsuario(clienteUpdateRequest.getEstadoUsuario()));

        return ClienteResponse.from(clienteRepository.save(cliente));
    }


}
