package com.utn.supergym.controllers;

import com.utn.supergym.dtos.pagos.PagoAltaRequest;
import com.utn.supergym.dtos.pase.PaseResponse;
import com.utn.supergym.services.PaseService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pases")
public class PaseController {

    private final PaseService paseService;

    @GetMapping("/{id}")
    public ResponseEntity<PaseResponse> consultarPase(@PathVariable("id") Long id)
            throws BadRequestException {
        validarId(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(paseService.consultarPase(id));
    }

    private void validarId(Long id) throws BadRequestException {
        if (null == id) {
            throw new BadRequestException("Se debe informar el ID de Pase a consultar.");
        }
    }


}
