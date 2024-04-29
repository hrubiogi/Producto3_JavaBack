package com.example.demo.controller;

import com.example.demo.entity.Alquiler;
import com.example.demo.services.AlquilerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/alquileres")
public class AlquilerController {

    @Autowired
    private AlquilerService alquilerService;

    @GetMapping
    public String listarAlquileres(Model model, Principal principal) {
        List<Alquiler> alquileres = alquilerService.findAlquileresByUsuario();
        model.addAttribute("alquileres", alquileres);
        return "alquileres/lista";
    }

    @GetMapping("/{alquilerId}")
    public Optional<Alquiler> getAlquilerById(@PathVariable("alquilerId") Long alquilerId) {
        return alquilerService.getAlquiler(alquilerId);
    }

    @PostMapping
    public String guardarAlquiler(@ModelAttribute("alquiler") Alquiler alquiler, Principal principal) {
        alquilerService.saveOrUpdateAlquiler(alquiler);
        return "redirect:/user/alquileres";
    }

    @DeleteMapping("/{alquilerId}")
    public void deleteAlquiler(@PathVariable("alquilerId") Long alquilerId) {
        alquilerService.deleteAlquiler(alquilerId);
    }
}
