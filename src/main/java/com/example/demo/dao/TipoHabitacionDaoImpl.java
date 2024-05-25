package com.example.demo.dao;

import com.example.demo.entidades.Habitacion;
import com.example.demo.entidades.TipoHabitacion;
import com.example.demo.repositorio.TipoHabitacionRepositorio;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoHabitacionDaoImpl implements ServicioGenerico<TipoHabitacion> {
    @Autowired
    private TipoHabitacionRepositorio tipoHabitacionRepositorio;

    @Override
    @Transactional
    public List<TipoHabitacion> listar() throws Exception {
        try {
            List<TipoHabitacion> entities = this.tipoHabitacionRepositorio.findAll();
            return entities;
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public TipoHabitacion buscarporId(long id) throws Exception {
        try {
            Optional<TipoHabitacion> opt = this.tipoHabitacionRepositorio.findById(id);
            return opt.get();
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public TipoHabitacion guardar(TipoHabitacion entity) throws Exception {
        try {
            TipoHabitacion tipoHabitacion = this.tipoHabitacionRepositorio.save(entity);
            return tipoHabitacion;
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public TipoHabitacion actualizar(TipoHabitacion entity, long id) throws Exception {
        try {
            Optional<TipoHabitacion> opt = this.tipoHabitacionRepositorio.findById(id);
            if(opt.isPresent()) {
                TipoHabitacion tipoHabitacion = opt.get();
                tipoHabitacion.setDescripcion(entity.getDescripcion());
                tipoHabitacion.setCantidadCamas(entity.getCantidadCamas());
                tipoHabitacion.setMaximoPersonas(entity.getMaximoPersonas());
                return this.tipoHabitacionRepositorio.save(tipoHabitacion);
            }else{
                throw new Exception("No se puede modificar el tipo de habitacion");
            }
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean eliminarporId(long id) throws Exception {
        try {
            Optional<TipoHabitacion> opt = this.tipoHabitacionRepositorio.findById(id);
            if(!opt.isEmpty()){
                TipoHabitacion tipoHabitacion=opt.get();
                tipoHabitacion.setActivo(!tipoHabitacion.isActivo());
                this.tipoHabitacionRepositorio.save(tipoHabitacion);
            }else{
                throw new Exception();
            }
            return true;
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    @Transactional
    public List<TipoHabitacion> findAllByActivo() throws Exception {
        try {
            List<TipoHabitacion> entities = this.tipoHabitacionRepositorio.findAllByActivo();
            return entities;
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
