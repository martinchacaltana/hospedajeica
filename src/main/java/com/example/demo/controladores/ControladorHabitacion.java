package com.example.demo.controladores;

import com.example.demo.dao.HabitacionDao;
import com.example.demo.dao.TipoHabitacionDao;
import com.example.demo.entidades.Habitacion;
import com.example.demo.entidades.TipoHabitacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ControladorHabitacion {
    @Autowired
    private HabitacionDao habitacionDao;
    @Autowired
    private TipoHabitacionDao tipoHabitacionDao;

    @GetMapping("/habitacion")
    public String habitacion(Model model) {
        model.addAttribute("habitacion", habitacionDao.obtenerTodos());
        return "habitacion";
    }

    @GetMapping("/habitacion/{id}")
    public String eliminarTipoHabitacion(@PathVariable Long id) {
        habitacionDao.eliminar(id);
        return "redirect:/habitacion";
    }

    @GetMapping("/habitacion/editar/{id}")
    public String mostrarFormEditar(@PathVariable Long id, Model model) {
        model.addAttribute("habitacion", habitacionDao.obtenerPorId(id));
        model.addAttribute("tipohabitacion", tipoHabitacionDao.obtenerTodos());
        return "editar_habitacion";
    }

    @PostMapping("/habitacion/{id}")
    public String actualizarTipoHabitacion(@PathVariable Long id, @ModelAttribute("habitacion") Habitacion habitacion, Model model) {
        Habitacion habitacionexistente = habitacionDao.obtenerPorId(id);
        habitacionexistente.setIDHabitacion(id);
        habitacionexistente.setNumeroHabitacion(habitacion.getNumeroHabitacion());
        habitacionexistente.setTipoHabitacion(habitacion.getTipoHabitacion());
        habitacionexistente.setDisponibilidad(habitacion.getDisponibilidad());
        habitacionDao.actualizarHabitacion(habitacionexistente);
        return "redirect:/habitacion";
    }

    @GetMapping("/habitacion/tipohabitacion")
    public String mostrarFormHabitacion(Model model) {
        Habitacion habitacion = new Habitacion();
        List<TipoHabitacion> tipoHabitacion = tipoHabitacionDao.obtenerTodos();
        model.addAttribute("habitacion", habitacion);
        model.addAttribute("tipohabitacion", tipoHabitacion);
        return "crear_habitacion";
    }

    @PostMapping("/habitacion")
    public String guardarHabitacion(@ModelAttribute("habitacion") Habitacion habitacion) {
        habitacionDao.agregarHabitacion(habitacion);
        return "redirect:/habitacion";
    }
}
