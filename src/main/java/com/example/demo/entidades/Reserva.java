package com.example.demo.entidades;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "reserva")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long IDReserva;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IDCliente", nullable = false)
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IDHabitacion", nullable = false)
    private Habitacion habitacion;

    @Positive(message = "Ingrese cantidad de personas correcta")
    @NotNull(message = "No se puede dejar en blanco")
    private Short cantidadpersonas;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "No puede dejarse en blanco")
    @FutureOrPresent(message = "Ingrese fecha valida")
    private LocalDate fechaentrada;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "No puede dejarse en blanco")
    @Future(message = "Ingrese fecha valida")
    private  LocalDate fechasalida;

    private boolean estadoreserva;

    private boolean activo = true;
}
