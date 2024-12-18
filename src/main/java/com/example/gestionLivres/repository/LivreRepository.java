package com.example.gestionLivres.repository;


import com.example.gestionLivres.model.Livre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivreRepository extends JpaRepository<Livre, Long> {
}
