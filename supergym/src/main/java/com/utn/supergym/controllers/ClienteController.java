package com.utn.supergym.controllers;

import com.utn.supergym.dtos.request.ClienteRequest;
import com.utn.supergym.services.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Void> darDeAltaCliente(@RequestBody ClienteRequest cliente) {
        clienteService.darDeAltaCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


}
