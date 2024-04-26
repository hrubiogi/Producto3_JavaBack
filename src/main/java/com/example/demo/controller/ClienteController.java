package com.example.demo.controller;

import com.example.demo.entity.Cliente;
import com.example.demo.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> getAll(){
        return clienteService.getsClientes();
    }

    @GetMapping("/{clienteId}")
    public Optional<Cliente> getBId(@PathVariable("clienteId") Long clienteId){
        return clienteService.getCliente(clienteId);
    }

    @PostMapping
    public void saveUpdate(@RequestBody Cliente cliente){
        clienteService.saveOrUpdate(cliente);
    }

    @DeleteMapping("/{clienteId}")
    public void saveUpdate(@PathVariable("clienteId") Long clienteId){
        clienteService.delete(clienteId);
    }
}
