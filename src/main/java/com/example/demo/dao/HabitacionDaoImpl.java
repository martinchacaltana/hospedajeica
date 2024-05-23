package com.example.demo.dao;

import com.example.demo.entidades.Habitacion;
import com.example.demo.entidades.TipoHabitacion;
import com.example.demo.repositorio.HabitacionRepositorio;
import com.example.demo.repositorio.TipoHabitacionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitacionDaoImpl implements HabitacionDao{
    @Autowired
    private HabitacionRepositorio habitacionRepositorio;

    @Override
    public List<Habitacion> obtenerTodos() {
        return habitacionRepositorio.findAll();
    }

    @Override
    public void eliminar(Long id) {
        habitacionRepositorio.deleteById(id);
    }

    @Override
    public Habitacion obtenerPorId(Long id) {
        return habitacionRepositorio.findById(id).get();
    }

    @Override
    public Habitacion actualizarHabitacion(Habitacion habitacion) {
        return habitacionRepositorio.save(habitacion);
    }

    @Override
    public Habitacion agregarHabitacion(Habitacion habitacion) {
        return habitacionRepositorio.save(habitacion);
    }
}
