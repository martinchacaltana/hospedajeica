package com.example.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentoIdentidad extends JpaRepository<com.example.demo.entidades.DocumentoIdentidad, Long> {
}
