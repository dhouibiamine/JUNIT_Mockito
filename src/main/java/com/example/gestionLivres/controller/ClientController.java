package com.example.gestionLivres.controller;


import com.example.gestionLivres.model.Client;
import com.example.gestionLivres.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping
    public List<Client> getAllClients() {
        return clientService.findAll();
    }

    @GetMapping("/{id}")
    public Client getClientById(@PathVariable int id) {
        return clientService.findById(id);
    }

    @PostMapping
    public Client createClient(@RequestBody Client client) {
        return clientService.save(client);
    }

    @PutMapping("/{id}")
    public Client updateClient(@PathVariable int id, @RequestBody Client updatedClient) {
        Client client = clientService.findById(id);
        client.setName(updatedClient.getName());
        client.setBirthDay(updatedClient.getBirthDay());
        return clientService.save(client);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable int id) {
        clientService.deleteById(id);
    }
}
