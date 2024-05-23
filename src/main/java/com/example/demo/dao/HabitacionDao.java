package com.example.demo.dao;

import com.example.demo.entidades.Habitacion;

import java.util.List;

public interface HabitacionDao {
    List<Habitacion> obtenerTodos();
    public void eliminar(Long id);
    public Habitacion obtenerPorId(Long id);
    public Habitacion actualizarHabitacion(Habitacion habitacion);
    public Habitacion agregarHabitacion(Habitacion habitacion);
}
