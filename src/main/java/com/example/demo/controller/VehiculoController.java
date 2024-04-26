package com.example.demo.controller;

import com.example.demo.entity.Vehiculo;
import com.example.demo.services.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "vehiculos")
public class VehiculoController {

    @Autowired
    private VehiculoService vehiculoService;

    @GetMapping
    public List<Vehiculo> getAllVehiculos() {
        return vehiculoService.getVehiculos();
    }

    @GetMapping("/{vehiculoId}")
    public Optional<Vehiculo> getVehiculoById(@PathVariable("vehiculoId") Long vehiculoId) {
        return vehiculoService.getVehiculo(vehiculoId);
    }
    
    
    
    @PostMapping("/add")
    public String addVehiculo(@ModelAttribute("vehiculo") Vehiculo vehiculo) {
        vehiculoService.saveOrUpdateVehiculo(vehiculo);
        return "redirect:/vehiculos/list"; // Redirige después de agregar el vehículo
    }
    
    @GetMapping("/add")
    public String showAddVehiculoForm(Model model) {
        model.addAttribute("vehiculo", new Vehiculo());
        return "addVehiculo"; // Este es el nombre de la plantilla Thymeleaf (addVehiculo.html)
    }
    
    @GetMapping("/list")
    public String showVehiculosList(Model model) {
        List<Vehiculo> vehiculos = vehiculoService.getVehiculos();
        model.addAttribute("vehiculos", vehiculos);
        return "vehiculosList"; // Nombre de la vista Thymeleaf (vehiculosList.html)
    }
    
    @PostMapping("/delete/{vehiculoId}")
    public String deleteVehiculo(@PathVariable("vehiculoId") Long vehiculoId) {
        vehiculoService.deleteVehiculo(vehiculoId);
        return "redirect:/vehiculos/list"; // Redirige después de eliminar el vehículo
    }
}

