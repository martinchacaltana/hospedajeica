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
import com.example.demo.dao.DocumentoImpl;
import com.example.demo.entidades.Cliente;

import jakarta.validation.Valid;

@Controller
public class ControladorCliente {
    @Autowired
    private ClienteImpl clienteImpl;
    @Autowired
    private DocumentoImpl documentoImpl;
    

    @GetMapping("/cliente")
    public String cliente(Model model) {
        try {
            List<Cliente> clientes = this.clienteImpl.listar();
            model.addAttribute("cliente", clientes);
            return "cliente";
        } catch (Exception e) {
            return "";
        }
    }

    @GetMapping("/cliente/form/{id}")
    public String nuevoCliente(Model model, @PathVariable("id") long id) {
        try {
            model.addAttribute("documento", this.documentoImpl.listar());
            if (id == 0) {
                model.addAttribute("cliente", new Cliente());
            } else {
                model.addAttribute("cliente", this.clienteImpl.buscarporId(id));
            }
            return "crear_cliente";
        } catch (Exception e) {
            return "";
        }
    }

    @PostMapping("/cliente/form/{id}")
    public String guardarCliente(@Valid @ModelAttribute("cliente") Cliente cliente, BindingResult result, Model model,
            @PathVariable("id") long id) {
        try {
            model.addAttribute("documento", this.documentoImpl.listar());
            if (result.hasErrors()) {
                return "crear_cliente";
            }
            if (id == 0) {
                this.clienteImpl.guardar(cliente);
            } else {
                this.clienteImpl.actualizar(cliente, id);
            }
            return "redirect:/cliente";
        } catch (Exception e) {
            return "";
        }
    }

    @GetMapping("/cliente/{id}")
    public String eliminarCliente(@PathVariable Long id) {
        try {
            this.clienteImpl.eliminarporId(id);
            return "redirect:/cliente";
        } catch (Exception e) {
            return "";
        }
    }

}
