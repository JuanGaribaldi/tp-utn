package com.utn.supergym.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "pase")
@Data
public class Pase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private TipoPase tipo;

    @Column
    private List<Producto> productosAsociados;

    @Column
    private LocalDateTime fechaEmision;

    @Column
    private LocalDateTime fechaProximoPago;

    @ElementCollection
    private List<Pago> pagosRealizados;

}
