package com.example.demo.services;

import com.example.demo.entity.Alquiler;
import com.example.demo.repository.AlquilerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlquilerService {

    @Autowired
    private AlquilerRepository alquilerRepository;

    public List<Alquiler> getAlquileres() {
        return alquilerRepository.findAll();
    }

    public Optional<Alquiler> getAlquiler(Long id) {
        return alquilerRepository.findById(id);
    }

    public void saveOrUpdateAlquiler(Alquiler alquiler) {
        alquilerRepository.save(alquiler);
    }

    public void deleteAlquiler(Long id) {
        alquilerRepository.deleteById(id);
    }

    public List<Alquiler> findAlquileresByUsuario() {
        return alquilerRepository.findAll();
    }
}
