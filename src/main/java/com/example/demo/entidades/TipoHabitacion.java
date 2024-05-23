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
    private Long CantidadCamas;

    @Column(name = "MaximoPersonas")
    private Long MaximoPersonas;

    public TipoHabitacion() {}

    public TipoHabitacion(Long maximoPersonas, Long cantidadCamas, String descripcion, Long IDTipoHabitacion) {
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

    public Long getCantidadCamas() {
        return CantidadCamas;
    }

    public void setCantidadCamas(Long cantidadCamas) {
        CantidadCamas = cantidadCamas;
    }

    public Long getMaximoPersonas() {
        return MaximoPersonas;
    }

    public void setMaximoPersonas(Long maximoPersonas) {
        MaximoPersonas = maximoPersonas;
    }
}
