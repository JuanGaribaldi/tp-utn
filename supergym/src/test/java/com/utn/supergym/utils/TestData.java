package com.utn.supergym.utils;

import com.utn.supergym.dtos.cliente.ClienteAltaRequest;
import com.utn.supergym.dtos.cliente.ClienteResponse;
import com.utn.supergym.dtos.cliente.ClienteUpdateRequest;
import com.utn.supergym.dtos.contrato.ContratoAltaRequest;
import com.utn.supergym.dtos.pagos.PagoAltaRequest;
import com.utn.supergym.dtos.pagos.PagoResponse;
import com.utn.supergym.entities.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class TestData {

    //datos generales
    public static final Long ID = 1L;
    public static final LocalDateTime FECHA = LocalDateTime.now().truncatedTo(ChronoUnit.DAYS);

    //datos cliente
    public static final Long DNI_CLIENTE = 123456789L;
    public static final String NOMBRE_CLIENTE = "Bruno";
    public static final String APELLIDO_CLIENTE = "Diaz";
    public static final String ESTADO_USUARIO_HABILITADO = "habilitado";


    //datos contrato
    public static final String TIPO_PASE = "black";
    public static final String PRODUCTO_MUSCULACION = "musculacion";
    public static final String PRODUCTO_CLASES = "clases";
    public static final String PRODUCTO_PILETA = "pileta";


    //datos pase
    public static final String TIPO_PASE_CLASSIC = "classic";
    public static final String TIPO_PASE_BLACK = "black";
    public static final String TIPO_PASE_PLATINUM = "platinum";


    //datos pagos
    public static final BigDecimal MONTO_PAGO = BigDecimal.TEN;

    //Mensajes de error
    public static final String ERROR_CLIENTE_EXISTENTE = "El cliente ya existe en el sistema.";
    public static final String ERROR_CLIENTE_NO_ENCONTRADO = "No se encontró el cliente con id: " + ID;

    public static ClienteAltaRequest getClienteAltaRequest() {
        return ClienteAltaRequest.builder()
                .nombre(NOMBRE_CLIENTE)
                .apellido(APELLIDO_CLIENTE)
                .dni(DNI_CLIENTE)
                .build();
    }

    public static ClienteUpdateRequest getClienteUpdateRequest() {
        return ClienteUpdateRequest.builder()
                .idCliente(ID)
                .estadoUsuario(ESTADO_USUARIO_HABILITADO)
                .build();
    }

    public static ContratoAltaRequest getContratoAltaRequest() {
        return ContratoAltaRequest.builder()
                .idCliente(ID)
                .monto(BigDecimal.TEN)
                .tipoPase(TIPO_PASE)
                .productos(List.of(PRODUCTO_CLASES, PRODUCTO_PILETA))
                .build();
    }

    public static PagoAltaRequest getPagoAltaRequest() {
        return PagoAltaRequest.builder()
                .idPase(ID)
                .fechaPago(DateUtil.toDateTimeString(FECHA))
                .montoPago(BigDecimal.TEN)
                .build();
    }

    public static PagoResponse getPagoResponse() {
        return PagoResponse.builder()
                .id(ID)
                .fechaPago(DateUtil.toDateTimeString(FECHA))
                .montoPago(BigDecimal.TEN)
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

    public static Contrato getContrato() {
        Contrato contrato = new Contrato();
        contrato.setId(ID);
        contrato.setCliente(getCliente());
        contrato.setPase(getPase());
        contrato.setFechaAlta(FECHA);
        contrato.setMonto(BigDecimal.TEN);
        return contrato;

    }

    public static Pase getPase() {
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

    public static List<Pago> getPagos() {
        return List.of(getPago(ID), getPago(ID + 1L));
    }

    public static Pago getPago(Long id) {
        Pago pago = new Pago();
        pago.setId(id);
        pago.setFechaPago(FECHA);
        pago.setMontoPago(MONTO_PAGO);
        return pago;
    }

    public static ClienteResponse getClienteResponse() {
        return ClienteResponse.from(getCliente());
    }
}
