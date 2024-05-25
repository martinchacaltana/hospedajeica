package com.example.demo.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "habitacion")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Habitacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long IDHabitacion;

    private int numeroHabitacion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IDTipoHabitacion", nullable = false)
    private TipoHabitacion tipoHabitacion ;

    private boolean disponibilidad;

    private boolean activo=true;
}
