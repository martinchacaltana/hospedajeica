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
import com.example.demo.dao.DocumentoImpl;
import com.example.demo.entidades.Documento;

import jakarta.validation.Valid;

@Controller
public class ControladorDocumento {
    @Autowired
    private DocumentoImpl documentoImpl;

    @GetMapping("/documento")
    public String documento(Model model) {
        try {
            List<Documento> documentos = this.documentoImpl.listar();
            model.addAttribute("documento", documentos);
            return "documento";
        } catch (Exception e) {
            return "";
        }
    }

    @GetMapping("/documento/form/{id}")
    public String nuevoTipoHabitacion(Model model, @PathVariable("id") long id) {
        try {
            if (id == 0) {
                model.addAttribute("documento", new Documento());
            } else {
                model.addAttribute("documento", this.documentoImpl.buscarporId(id));
            }
            return "crear_documento";
        } catch (Exception e) {
            return "";
        }
    }

    @PostMapping("/documento/form/{id}")
    public String guardarDocumento(@Valid @ModelAttribute("documento") Documento documento,BindingResult result, Model model,
            @PathVariable("id") long id) {
        try {
            if (result.hasErrors()) {
                return "crear_documento";
            }
            if (id == 0) {
                this.documentoImpl.guardar(documento);
            } else {
                this.documentoImpl.actualizar(documento, id);
            }
            return "redirect:/documento";
        } catch (Exception e) {
            return "";
        }
    }

    @GetMapping("/documento/{id}")
    public String eliminarTipoHabitacion(@PathVariable Long id) {
        try {
            this.documentoImpl.eliminarporId(id);
            return "redirect:/documento";
        } catch (Exception e) {
            return "";
        }
    }

}
