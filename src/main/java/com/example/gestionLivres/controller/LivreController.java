package com.example.gestionLivres.controller;


import com.example.gestionLivres.model.Livre;
import com.example.gestionLivres.service.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livres")
public class LivreController {
    @Autowired
    private LivreService livreService;

    @GetMapping
    public List<Livre> getAllLivres() {
        return livreService.findAll();
    }

    @GetMapping("/{id}")
    public Livre getLivreById(@PathVariable Long id) {
        return livreService.findById(id);
    }

    @PostMapping
    public Livre createLivre(@RequestBody Livre livre) {
        return livreService.save(livre);
    }



    @DeleteMapping("/{id}")
    public void deleteLivre(@PathVariable Long id) {
        livreService.deleteById(id);
    }
}
