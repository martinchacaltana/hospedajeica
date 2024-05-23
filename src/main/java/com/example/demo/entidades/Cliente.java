package com.example.demo.entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Idcliente;

    @Column (name = "nombreCliente")
    private String nombreCliente;

    
}
