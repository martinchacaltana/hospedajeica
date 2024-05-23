package com.example.demo.controladores;

import com.example.demo.dao.TipoHabitacionDao;
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
public class ControladorTipoHabitacion {
    @Autowired
    private TipoHabitacionDao tipoHabitacionDao;

    @GetMapping("/tipohabitacion")
    public String listarTipoHabitacion(Model model) {
        model.addAttribute("tipoHabitacion",tipoHabitacionDao.obtenerTodos());
        return "tipohabitacion";
    }

    @GetMapping("/tipohabitacion/{id}")
    public String eliminarTipoHabitacion(@PathVariable Long id) {
        tipoHabitacionDao.eliminar(id);
        return "redirect:/tipohabitacion";
    }

    @GetMapping("/tipohabitacion/editar/{id}")
    public String mostrarFormEditar(@PathVariable Long id, Model model){
        model.addAttribute("tipoHabitacion",tipoHabitacionDao.obtenerPorId(id));
        return "editar_tipohabitacion";
    }

    @PostMapping("/tipohabitacion/{id}")
    public String actualizarTipoHabitacion(@PathVariable Long id, @ModelAttribute("tipohabitacion") TipoHabitacion tipoHabitacion, Model model){
        TipoHabitacion tipoExistente = tipoHabitacionDao.obtenerPorId(id);
        tipoExistente.setDescripcion(tipoHabitacion.getDescripcion());
        tipoExistente.setCantidadCamas(tipoHabitacion.getCantidadCamas());
        tipoExistente.setMaximoPersonas(tipoHabitacion.getMaximoPersonas());
        tipoHabitacionDao.actualizarTipoHabitacion(tipoExistente);
        return "redirect:/tipohabitacion";
    }
    @GetMapping("/tipohabitacion/nuevotipohabitacion")
    public String mostrarFormTipoHabitacion(Model model){
        TipoHabitacion tipoHabitacion = new TipoHabitacion();
        model.addAttribute("tipoHabitacion",tipoHabitacion);
        return "crear_tipohabitacion";
    }
    @PostMapping("/tipohabitacion")
    public String guardarTipoHabitacion(@ModelAttribute("tipohabitacion") TipoHabitacion tipoHabitacion) {
        tipoHabitacionDao.agregarTipoHabitacion(tipoHabitacion);
        return "redirect:/tipohabitacion";
    }
}
