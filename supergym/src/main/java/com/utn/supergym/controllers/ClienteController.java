package com.utn.supergym.controllers;

import com.utn.supergym.dtos.cliente.*;
import com.utn.supergym.exceptions.AltaException;
import com.utn.supergym.services.ClienteService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping
    public ResponseEntity<ClienteAltaResponse> darDeAltaCliente(@RequestBody ClienteAltaRequest cliente)
            throws AltaException {
        ClienteAltaResponse response = clienteService.darDeAltaCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PatchMapping
    public ResponseEntity<ClienteUpdateResponse> actualizarCliente(@RequestBody ClienteUpdateRequest clienteRequest) throws BadRequestException {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(clienteService.actualizarEstado(clienteRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteConsultaResponse> consultarCliente(@PathVariable("id") Long idCliente) {
        ClienteConsultaResponse response = clienteService.consultarCliente(idCliente);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
