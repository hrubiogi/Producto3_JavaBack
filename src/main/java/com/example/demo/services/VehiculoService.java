package com.example.demo.services;

import com.example.demo.entity.Vehiculo;
import com.example.demo.repository.VehiculoRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class VehiculoService {
	
    private static final Logger logger = LoggerFactory.getLogger(VehiculoService.class);


    @Autowired
    private VehiculoRepository vehiculoRepository;

    public List<Vehiculo> getVehiculos() {
        return vehiculoRepository.findAll();
    }

    public Optional<Vehiculo> getVehiculo(Long id) {
        return vehiculoRepository.findById(id);
    }

    @Transactional
    public void saveOrUpdateVehiculo(Vehiculo vehiculo) {
    	logger.info("Guardando o actualizando vehículo: {}", vehiculo);
        vehiculoRepository.save(vehiculo);
    }

    public void deleteVehiculo(Long id) {
        vehiculoRepository.deleteById(id);
    }
}
