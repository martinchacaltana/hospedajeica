package com.example.demo.entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "habitacion")

public class Habitacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IDHabitacion;

    @Column(name = "numeroHabitacion")
    private Long numeroHabitacion;

    @ManyToOne
    @JoinColumn(name = "IDTipoHabitacion", nullable = false)
    private TipoHabitacion tipoHabitacion ;

    @Column(name = "disponibilidad")
    private Boolean disponibilidad;

    public Habitacion() {}

    public Habitacion(Long IDHabitacion, Long numeroHabitacion, TipoHabitacion tipoHabitacion, Boolean disponibilidad) {
        this.IDHabitacion = IDHabitacion;
        this.numeroHabitacion = numeroHabitacion;
        this.tipoHabitacion = tipoHabitacion;
        this.disponibilidad = disponibilidad;
    }

    public Long getIDHabitacion() {
        return IDHabitacion;
    }

    public void setIDHabitacion(Long IDHabitacion) {
        this.IDHabitacion = IDHabitacion;
    }

    public Long getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public void setNumeroHabitacion(Long numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }

    public TipoHabitacion getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public Boolean getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(Boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
}
