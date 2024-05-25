package com.example.demo.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="TipoHabitacion")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TipoHabitacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long IDTipoHabitacion;
    private String Descripcion;
    private int CantidadCamas;
    private int MaximoPersonas;
    private boolean activo=true;

    @OneToMany(mappedBy = "tipoHabitacion")
    private List<Habitacion> habitaciones;

}
