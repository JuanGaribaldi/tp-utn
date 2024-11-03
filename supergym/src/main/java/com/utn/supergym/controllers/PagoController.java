package com.utn.supergym.controllers;

import com.utn.supergym.dtos.alta.request.ContratoRequest;
import com.utn.supergym.dtos.alta.request.PagoRequest;
import com.utn.supergym.entities.Pago;
import com.utn.supergym.entities.Producto;
import com.utn.supergym.entities.TipoPase;
import com.utn.supergym.exceptions.AltaException;
import com.utn.supergym.services.PagoService;
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
@RequestMapping("/pagos")
public class PagoController {

    private final PagoService pagoService;

    @PostMapping
    public ResponseEntity<Void> darDeAltaContrato(@RequestBody PagoRequest pagoRequest) throws AltaException, BadRequestException {
        validarBodyContrato(pagoRequest);
        pagoService.darDeAltaPago(pagoRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    private void validarBodyContrato(PagoRequest pagoRequest) throws BadRequestException {
//        if (null == pagoRequest.getFechaPago()) {
//            throw new BadRequestException("Se debe informar Fecha Pago");
//        }
        if (null == pagoRequest.getMontoPago()) {
            throw new BadRequestException("Se debe informar Monto Pago");
        }
    }


}
