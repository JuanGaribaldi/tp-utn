package com.utn.supergym.controllers;

import com.utn.supergym.dtos.pagos.PagoAltaRequest;
import com.utn.supergym.exceptions.AltaException;
import com.utn.supergym.services.PagoService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pagos")
public class PagoController {

    private final PagoService pagoService;

    @PostMapping
    public ResponseEntity<Void> registrarPago(@RequestBody PagoAltaRequest pagoAltaRequest)
            throws AltaException, BadRequestException {
        validarBodyContrato(pagoAltaRequest);
        pagoService.darDeAltaPago(pagoAltaRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    private void validarBodyContrato(PagoAltaRequest pagoAltaRequest) throws BadRequestException {
        if (null == pagoAltaRequest.getIdPase()) {
            throw new BadRequestException("Se debe informar ID de Pase");
        }
        if (null == pagoAltaRequest.getMontoPago()) {
            throw new BadRequestException("Se debe informar Monto Pago");
        }
    }


}
