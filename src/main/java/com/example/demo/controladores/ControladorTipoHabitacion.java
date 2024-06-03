package com.example.demo.controladores;

import com.example.demo.dao.TipoHabitacionDaoImpl;
import com.example.demo.entidades.TipoHabitacion;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ControladorTipoHabitacion {
    @Autowired
    private TipoHabitacionDaoImpl servicioTipoHabitacion;

    @GetMapping("/tipohabitacion")
    public String tipohabitacion(Model model) {
        try {
            List<TipoHabitacion> tipohabitaciones = this.servicioTipoHabitacion.findAllByActivo();
            model.addAttribute("tipohabitaciones", tipohabitaciones);
            return "tipohabitacion";
        } catch (Exception e) {
            return "";
        }
    }

    @GetMapping("/tipohabitacion/form/{id}")
    public String nuevoTipoHabitacion(Model model, @PathVariable("id") long id) {
        try {
            if (id == 0) {
                model.addAttribute("tipohabitacion", new TipoHabitacion());
            } else {
                model.addAttribute("tipohabitacion", this.servicioTipoHabitacion.buscarporId(id));
            }
            return "crear_tipohabitacion";
        } catch (Exception e) {
            return "";
        }
    }

    @PostMapping("/tipohabitacion/form/{id}")
    public String guardarTipoHabitacion(@Valid @ModelAttribute("tipohabitacion") TipoHabitacion tipohabitacion,
            BindingResult result, Model model, @PathVariable("id") long id) {
        try {
            if (result.hasErrors()) {
                return "crear_tipohabitacion";
            }
            if (id == 0) {
                this.servicioTipoHabitacion.guardar(tipohabitacion);
            } else {
                this.servicioTipoHabitacion.actualizar(tipohabitacion, id);
            }
            return "redirect:/tipohabitacion";
        } catch (Exception e) {
            return "";
        }
    }

    @GetMapping("/tipohabitacion/{id}")
    public String eliminarTipoHabitacion(@PathVariable Long id) {
        try {
            this.servicioTipoHabitacion.eliminarporId(id);
            return "redirect:/tipohabitacion";
        } catch (Exception e) {
            return "";
        }
    }

}
