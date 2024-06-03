package com.example.demo.entidades;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "habitacion")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Habitacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long IDHabitacion;

    @NotNull(message = "No puede estar vacio")
    @Max(value = 999, message = "Ingrese numero valido")
    private Short numeroHabitacion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IDTipoHabitacion", nullable = false)
    private TipoHabitacion tipoHabitacion;

    private boolean disponibilidad;
    @NotNull(message = "No puede estar vacio")
    private BigDecimal precio;

    private boolean activo = true;

    @OneToMany(mappedBy = "habitacion")
    private List<Reserva> reservas;
}
