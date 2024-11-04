package com.utn.supergym.utils;

import com.utn.supergym.dtos.cliente.ClienteAltaRequest;
import com.utn.supergym.entities.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class TestData {

    //datos generales
    public static final Long ID = 1L;
    public static final LocalDateTime FECHA = LocalDateTime.now();

    //datos cliente
    public static final Long DNI_CLIENTE = 123456789L;
    public static final String NOMBRE_CLIENTE = "Bruno";
    public static final String APELLIDO_CLIENTE = "Diaz";

    //datos contrato

    //datos pase

    //datos pagos
    public static ClienteAltaRequest getClienteAltaRequest() {
        return ClienteAltaRequest.builder()
                .nombre(NOMBRE_CLIENTE)
                .apellido(APELLIDO_CLIENTE)
                .dni(DNI_CLIENTE)
                .build();
    }

    public static Cliente getCliente() {
        Cliente cliente = new Cliente();
        cliente.setId(ID);

        cliente.setNombre(NOMBRE_CLIENTE);
        cliente.setApellido(APELLIDO_CLIENTE);
        cliente.setDni(DNI_CLIENTE);
        cliente.setEstadoUsuario(EstadoUsuario.CREADO);
        return cliente;
    }

    private static Contrato getContrato() {
        Contrato contrato = new Contrato();
        contrato.setId(ID);
        contrato.setCliente(getCliente());
        contrato.setPase(getPase());
        contrato.setFechaAlta(FECHA);
        contrato.setMonto(BigDecimal.TEN);
        return contrato;

    }

    private static Pase getPase() {
        Pase pase = new Pase();
        pase.setId(ID);
        pase.setCliente(getCliente());
        pase.setTipo(TipoPase.BLACK);
        pase.setProductosAsociados(List.of(Producto.MUSCULACION, Producto.PILETA));
        pase.setFechaEmision(FECHA);
        pase.setFechaProximoPago(FECHA);
        pase.setPagosRealizados(getPagos());
        return pase;
    }

    private static List<Pago> getPagos() {
        return List.of(getPago(ID), getPago(ID + 1L));
    }

    private static Pago getPago(Long id) {
        Pago pago = new Pago();
        pago.setId(id);
        pago.setFechaPago(FECHA);
        pago.setMontoPago(BigDecimal.TEN);
        return pago;
    }
}
