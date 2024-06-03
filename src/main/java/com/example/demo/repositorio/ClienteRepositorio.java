package com.example.demo.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entidades.Cliente;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {
    @Query(value = "SELECT * FROM cliente WHERE cliente.activo=true", nativeQuery = true)
    List<Cliente> findAllByActivo();
}
