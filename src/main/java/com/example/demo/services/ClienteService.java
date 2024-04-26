package com.example.demo.services;

import com.example.demo.entity.Cliente;
import com.example.demo.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public List<Cliente> getsClientes(){
        return clienteRepository.findAll();
    }
    public Optional<Cliente> getCliente(Long id){
        return clienteRepository.findById(id);
    }
    public void saveOrUpdate(Cliente cliente){
        clienteRepository.save(cliente);
    }
    public void delete(Long id){
        clienteRepository.deleteById(id);
    }

}
