package com.utn.supergym.dtos.errores;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorGenericoDto {
    private String mensaje;
}
