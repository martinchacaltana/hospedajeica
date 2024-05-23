package com.example.demo.dao;

import com.example.demo.entidades.TipoHabitacion;
import com.example.demo.repositorio.TipoHabitacionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoHabitacionDaoImpl implements TipoHabitacionDao{
    @Autowired
    private TipoHabitacionRepositorio tipoHabitacionRepositorio;


    @Override
    public List<TipoHabitacion> obtenerTodos() {
        return tipoHabitacionRepositorio.findAll();
    }

    @Override
    public void eliminar(Long id) {
        tipoHabitacionRepositorio.deleteById(id);
    }

    @Override
    public TipoHabitacion obtenerPorId(Long id) {
        return tipoHabitacionRepositorio.findById(id).get();
    }

    @Override
    public TipoHabitacion actualizarTipoHabitacion(TipoHabitacion tipoHabitacion) {
        return tipoHabitacionRepositorio.save(tipoHabitacion);
    }

    @Override
    public TipoHabitacion agregarTipoHabitacion(TipoHabitacion tipoHabitacion) {
        return tipoHabitacionRepositorio.save(tipoHabitacion);
    }
}
