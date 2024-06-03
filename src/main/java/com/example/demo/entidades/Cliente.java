package com.example.demo.entidades;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cliente")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long IDCliente;
    @NotEmpty(message = "{NotEmpty.Cliente.nombre}")
    private String nombre;
    @NotNull(message = "Se requiere indicar tipo de documento")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IDDocumento", nullable = false)
    private Documento documento;
    @NotNull(message = "No se puede dejar en blanco")
    @Min(value = 10000000, message = "Valor minimo de 8 digitos")
    private BigInteger numerodocumento;
    @Email(message = "Ingrese un correo valido")
    @NotEmpty(message = "No se puede dejar vacio")
    private String correo;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "No puede dejarse en blanco")
    @PastOrPresent(message = "Ingrese fecha valida")
    private Date fechanacimiento;
    private boolean activo = true;

    @OneToMany(mappedBy = "cliente")
    private List<Reserva> reservas;
}
