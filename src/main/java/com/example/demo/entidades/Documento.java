package com.example.demo.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="documento")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Documento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long IDDocumento;
    @NotEmpty(message = "No puede estar vacio")
    private String nombreDocumento;
    @NotEmpty(message = "No puede estar vacio")
    private String abreviatura;
    private boolean activo=true;
}
