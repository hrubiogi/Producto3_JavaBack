package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import java.security.Principal;
import java.util.Set;

import com.example.demo.entity.Alquiler;
import com.example.demo.entity.User;
import com.example.demo.services.UserService;


@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/login";
    }

    // Página de perfil del usuario
    @GetMapping("/perfil")
    public String perfilUsuario(Model model, Principal principal) {
        User usuario = userService.findByUsername(principal.getName());
        model.addAttribute("usuario", usuario);
        return "usuario/perfil";
    }

    // Lista de alquileres del usuario
    @GetMapping("/alquileres")
    public String listarAlquileresDelUsuario(Model model, Principal principal) {
        UserService userService = new UserService();
        User usuario = userService.findByUsername(principal.getName());
        Set<Alquiler> alquileres = usuario.getAlquileres();
        model.addAttribute("alquileres", alquileres);
        return "alquileres/lista";
    }

}