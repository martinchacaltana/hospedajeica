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
    @GetMapping("/service")
    public String service() {
        return "service";
    }

    @GetMapping("/room")
    public String room() {
        return "room";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/booking")
    public String booking() {
        return "booking";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    @GetMapping("/team")
    public String team() {
        return "team";
    }

    @GetMapping("/testimonial")
    public String testimonial() {
        return "testimonial";
    }

}
