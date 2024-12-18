package com.example.gestionLivres.repository;


import com.example.gestionLivres.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
