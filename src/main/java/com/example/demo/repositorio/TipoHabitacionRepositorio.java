package com.example.demo.repositorio;

import com.example.demo.entidades.Habitacion;
import com.example.demo.entidades.TipoHabitacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TipoHabitacionRepositorio extends JpaRepository<TipoHabitacion,Long> {
    @Query(value = "SELECT * FROM tipohabitacion WHERE tipohabitacion.activo=true", nativeQuery = true)
    List<TipoHabitacion> findAllByActivo();
}
