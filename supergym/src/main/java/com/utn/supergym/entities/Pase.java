package com.utn.supergym.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

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

    @ElementCollection
    private List<Producto> productosAsociados;

    @Column
    @CreationTimestamp
    private LocalDateTime fechaEmision;

    @Column
    @CreationTimestamp
    private LocalDateTime fechaProximoPago;

    @ElementCollection
    private List<Pago> pagosRealizados;


    public void addPagoRealizado(Pago pago) {
        pagosRealizados.add(pago);
    }
}
