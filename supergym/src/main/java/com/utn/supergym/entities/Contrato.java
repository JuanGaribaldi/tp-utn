package com.utn.supergym.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "contrato")
@Data
public class Contrato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Cliente cliente;

    @OneToOne
    private Pase pase;

    @Column
    private LocalDateTime fechaAlta;

    @Column
    private BigDecimal monto;

    private void pagarMes() {
        //TODO: implementar
    }

}
