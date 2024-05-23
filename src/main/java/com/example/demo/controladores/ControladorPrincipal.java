package com.example.demo.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControladorPrincipal {
@GetMapping("/")
    public String index() {
        return "index";
    }

@GetMapping("/dashboard")
    public String dashboard() {
    return "dashboard";
}
@GetMapping("/login")
    public String login() {
    return "login";
}
@GetMapping("/registro")
    public String registro() {
    return "register";
}
}
