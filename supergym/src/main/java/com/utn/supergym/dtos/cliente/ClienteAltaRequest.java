package com.utn.supergym.dtos.cliente;

import com.utn.supergym.entities.Cliente;
import com.utn.supergym.entities.EstadoUsuario;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClienteAltaRequest {
    @NotEmpty
    private String nombre;
    @NotEmpty
    private String apellido;
    @NotEmpty
    private Long dni;

    public Cliente toCliente() {
        Cliente cliente = new Cliente();
        cliente.setNombre(this.nombre);
        cliente.setApellido(this.apellido);
        cliente.setDni(this.dni);
        cliente.setEstadoUsuario(EstadoUsuario.CREADO);
        return cliente;
    }
}