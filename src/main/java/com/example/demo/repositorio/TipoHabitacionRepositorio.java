package com.example.demo.repositorio;

import com.example.demo.entidades.TipoHabitacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoHabitacionRepositorio extends JpaRepository<TipoHabitacion,Long> {
}
