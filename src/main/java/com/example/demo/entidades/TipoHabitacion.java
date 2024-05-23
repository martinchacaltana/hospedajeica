package com.example.demo.entidades;

import jakarta.persistence.*;

@Entity
@Table(name="TipoHabitacion")
public class TipoHabitacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDTipoHabitacion")
    private Long IDTipoHabitacion;

    @Column(name = "Descripcion", nullable = false,length = 50)
    private String Descripcion;

    @Column(name = "CantidadCamas")
    private long CantidadCamas;

    @Column(name = "MaximoPersonas")
    private long MaximoPersonas;

    public TipoHabitacion() {}

    public TipoHabitacion(long maximoPersonas, long cantidadCamas, String descripcion, Long IDTipoHabitacion) {
        MaximoPersonas = maximoPersonas;
        CantidadCamas = cantidadCamas;
        Descripcion = descripcion;
        this.IDTipoHabitacion = IDTipoHabitacion;
    }

    public Long getIDTipoHabitacion() {
        return IDTipoHabitacion;
    }

    public void setIDTipoHabitacion(Long IDTipoHabitacion) {
        this.IDTipoHabitacion = IDTipoHabitacion;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public long getCantidadCamas() {
        return CantidadCamas;
    }

    public void setCantidadCamas(long cantidadCamas) {
        CantidadCamas = cantidadCamas;
    }

    public long getMaximoPersonas() {
        return MaximoPersonas;
    }

    public void setMaximoPersonas(long maximoPersonas) {
        MaximoPersonas = maximoPersonas;
    }
}
