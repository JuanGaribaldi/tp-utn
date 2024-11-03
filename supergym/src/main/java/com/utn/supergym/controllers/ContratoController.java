package com.utn.supergym.controllers;

import com.utn.supergym.dtos.contrato.ContratoRequest;
import com.utn.supergym.entities.Producto;
import com.utn.supergym.entities.TipoPase;
import com.utn.supergym.exceptions.AltaException;
import com.utn.supergym.services.ContratoService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/contratos")
public class ContratoController {

    private final ContratoService contratoService;

    @PostMapping
    public ResponseEntity<Void> darDeAltaContrato(@RequestBody ContratoRequest contratoRequest) throws AltaException, BadRequestException {
        validarBodyContrato(contratoRequest);
        contratoService.darDeAltaContrato(contratoRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    private void validarBodyContrato(ContratoRequest contratoRequest) throws BadRequestException {
        if (!TipoPase.esTipoPaseValido(contratoRequest.getTipoPase())) {
            throw new BadRequestException("Tipo Pase inválido");
        }
        if (TipoPase.BLACK.toString().equalsIgnoreCase(contratoRequest.getTipoPase())) {
            List<String> productos = contratoRequest.getProductos();
            if (CollectionUtils.isEmpty(productos)) {
                throw new BadRequestException("Si el tipo de pase es Black, debe informar productos a asociar");
            }
            if (!Producto.sonProductosValidos(productos)) {
                throw new BadRequestException("Productos inválidos");
            }
            if (productos.size() != 2) {
                throw new BadRequestException("Si elige tipo de pase Black, debe informar dos Servicios");
            }
        }
    }
}
