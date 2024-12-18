package com.example.gestionLivres.service;


import com.example.gestionLivres.model.Client;
import com.example.gestionLivres.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public Client findById(int id) {
        return clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Client not found"));
    }

    public Client save(Client client) {
        return clientRepository.save(client);
    }

    public void deleteById(int id) {
        clientRepository.deleteById(id);
    }
}
