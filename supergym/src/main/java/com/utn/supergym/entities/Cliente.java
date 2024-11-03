package com.utn.supergym.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private Long dni;
    @OneToOne
    private Contrato contrato;
    @Column
    @Enumerated(EnumType.STRING)
    private EstadoUsuario estadoUsuario;
}
