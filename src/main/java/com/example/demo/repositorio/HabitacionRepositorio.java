package com.example.demo.repositorio;

import com.example.demo.entidades.Habitacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface HabitacionRepositorio extends JpaRepository<com.example.demo.entidades.Habitacion,Long> {
    @Query(value = "SELECT * FROM habitacion WHERE habitacion.activo=true", nativeQuery = true)
    List<Habitacion> findAllByActivo();

    @Query(value = "SELECT * FROM habitacion WHERE habitacion.IDHabitacion = :id AND habitacion.activo = true", nativeQuery = true)
    Optional<Habitacion> findByIdAAndActivo(@Param("id") long IDHabitacion);
}
