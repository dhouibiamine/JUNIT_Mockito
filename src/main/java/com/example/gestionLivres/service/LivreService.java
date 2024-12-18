package com.example.gestionLivres.service;


import com.example.gestionLivres.model.Livre;
import com.example.gestionLivres.repository.LivreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivreService {
    @Autowired
    private LivreRepository livreRepository;

    public List<Livre> findAll() {
        return livreRepository.findAll();
    }

    public Livre findById(Long id) {
        return livreRepository.findById(id).orElseThrow(() -> new RuntimeException("Livre not found"));
    }

    public Livre save(Livre livre) {
        return livreRepository.save(livre);
    }

    public void deleteById(Long id) {
        livreRepository.deleteById(id);
    }
}

