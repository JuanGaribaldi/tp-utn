package com.utn.supergym.controllers;

import com.utn.supergym.dtos.contrato.ContratoAltaRequest;
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
    public ResponseEntity<Void> darDeAltaContrato(@RequestBody ContratoAltaRequest contratoAltaRequest) throws AltaException, BadRequestException {
        validarBodyContrato(contratoAltaRequest);
        contratoService.darDeAltaContrato(contratoAltaRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    private void validarBodyContrato(ContratoAltaRequest contratoAltaRequest) throws BadRequestException {
        if (!TipoPase.esTipoPaseValido(contratoAltaRequest.getTipoPase())) {
            throw new BadRequestException("Tipo Pase inválido");
        }
        if (TipoPase.BLACK.toString().equalsIgnoreCase(contratoAltaRequest.getTipoPase())) {
            List<String> productos = contratoAltaRequest.getProductos();
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
