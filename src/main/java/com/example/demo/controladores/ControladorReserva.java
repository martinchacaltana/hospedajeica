package com.example.demo.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dao.ClienteImpl;
import com.example.demo.dao.HabitacionDaoImpl;
import com.example.demo.dao.ReservaImpl;
import com.example.demo.entidades.Reserva;

import jakarta.validation.Valid;
@Controller
public class ControladorReserva {
    @Autowired
    private ReservaImpl reservaImpl;
    @Autowired
    private ClienteImpl clienteImpl;
    @Autowired
    private HabitacionDaoImpl habitacionDaoImpl;

    @GetMapping("/reserva")
    public String reserva(Model model) {
        try {
            List<Reserva> reservas = this.reservaImpl.listar();
            model.addAttribute("reserva", reservas);
            return "reserva";
        } catch (Exception e) {
            return "";
        }
    }

    @GetMapping("/reserva/form/{id}")
    public String nuevaReserva(Model model, @PathVariable("id") long id) {
        try {
            model.addAttribute("cliente", this.clienteImpl.listar());
            model.addAttribute("habitacion", this.habitacionDaoImpl.findAllByActivoAndDisponibilidad());
            if (id == 0) {
                model.addAttribute("reserva", new Reserva());
            } else {
                model.addAttribute("reserva", this.reservaImpl.buscarporId(id));
            }
            return "crear_reserva";
        } catch (Exception e) {
            return "";
        }
    }

    @PostMapping("/reserva/form/{id}")
    public String guardarReserva(@Valid @ModelAttribute("reserva") Reserva reserva, BindingResult result, Model model,
            @PathVariable("id") long id) {
        try {
            model.addAttribute("cliente", this.clienteImpl.listar());
            model.addAttribute("habitacion", this.habitacionDaoImpl.findAllByActivoAndDisponibilidad());
            if (result.hasErrors()) {
                return "crear_reserva";
            }
            if (id == 0) {
                this.reservaImpl.guardar(reserva);
            } else {
                this.reservaImpl.actualizar(reserva, id);
            }
            return "redirect:/reserva";
        } catch (Exception e) {
            return "";
        }
    }

    @GetMapping("/reserva/{id}")
    public String eliminarReserva(@PathVariable Long id) {
        try {
            this.reservaImpl.eliminarporId(id);
            return "redirect:/reserva";
        } catch (Exception e) {
            return "";
        }
    }

}
