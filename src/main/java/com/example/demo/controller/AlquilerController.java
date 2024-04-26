package com.example.demo.controller;

import com.example.demo.entity.Alquiler;
import com.example.demo.services.AlquilerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/alquileres")
public class AlquilerController {

    @Autowired
    private AlquilerService alquilerService;

    @GetMapping
    public List<Alquiler> getAllAlquileres() {
        return alquilerService.getAlquileres();
    }

    @GetMapping("/{alquilerId}")
    public Optional<Alquiler> getAlquilerById(@PathVariable("alquilerId") Long alquilerId) {
        return alquilerService.getAlquiler(alquilerId);
    }

    @PostMapping
    public void saveOrUpdateAlquiler(@RequestBody Alquiler alquiler) {
        alquilerService.saveOrUpdateAlquiler(alquiler);
    }

    @DeleteMapping("/{alquilerId}")
    public void deleteAlquiler(@PathVariable("alquilerId") Long alquilerId) {
        alquilerService.deleteAlquiler(alquilerId);
    }
}
