package com.utn.supergym.configuration.handler;

import com.utn.supergym.dtos.errores.ErrorGenericoDto;
import com.utn.supergym.exceptions.AltaException;
import com.utn.supergym.exceptions.UpdateException;
import org.apache.coyote.BadRequestException;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.NoSuchElementException;

@RestControllerAdvice
@Configuration
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({AltaException.class})
    public ResponseEntity<ErrorGenericoDto> handle(AltaException altaException) {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body(ErrorGenericoDto.builder().mensaje(altaException.getMessage()).build());
    }

    @ExceptionHandler({UpdateException.class})
    public ResponseEntity<ErrorGenericoDto> handle(UpdateException updateException) {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body(ErrorGenericoDto.builder().mensaje(updateException.getMessage()).build());
    }

    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<ErrorGenericoDto> handle(BadRequestException badRequestException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ErrorGenericoDto.builder().mensaje(badRequestException.getMessage()).build());
    }

    @ExceptionHandler({NoSuchElementException.class})
    public ResponseEntity<ErrorGenericoDto> handle(NoSuchElementException exception) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body(ErrorGenericoDto.builder().mensaje(exception.getMessage()).build());
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<ErrorGenericoDto> handle(Exception exception) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ErrorGenericoDto.builder().mensaje(exception.getMessage()).build());
    }
}
