package com.example.demo.dao;

import com.example.demo.entidades.TipoHabitacion;

import java.util.List;

public interface TipoHabitacionDao {
    List<TipoHabitacion> obtenerTodos();
    public void eliminar(Long id);
    public TipoHabitacion obtenerPorId(Long id);
    public TipoHabitacion actualizarTipoHabitacion(TipoHabitacion tipoHabitacion);
    public TipoHabitacion agregarTipoHabitacion(TipoHabitacion tipoHabitacion);
}
