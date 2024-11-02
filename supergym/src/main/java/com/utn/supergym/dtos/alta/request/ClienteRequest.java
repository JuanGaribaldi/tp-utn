package com.utn.supergym.dtos.alta.request;

import com.utn.supergym.entities.Cliente;
import com.utn.supergym.entities.EstadoUsuario;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClienteRequest {
    private String nombre;
    private String apellido;
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
