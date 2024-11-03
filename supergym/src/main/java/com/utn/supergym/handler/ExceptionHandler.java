package com.utn.supergym.handler;

import com.utn.supergym.dtos.errores.ErrorGenericoDto;
import com.utn.supergym.exceptions.AltaException;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler({AltaException.class})
    public ResponseEntity<ErrorGenericoDto> handle(AltaException altaException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ErrorGenericoDto.builder().mensaje(altaException.getMessage()).build());
    }

    @org.springframework.web.bind.annotation.ExceptionHandler({BadRequestException.class})
    public ResponseEntity<ErrorGenericoDto> handle(BadRequestException badRequestException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ErrorGenericoDto.builder().mensaje(badRequestException.getMessage()).build());
    }
}
