package com.example.gestionLivres;


import com.example.gestionLivres.controller.LivreController;
import com.example.gestionLivres.model.Livre;
import com.example.gestionLivres.service.LivreService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(LivreController.class)
class LivreControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LivreService livreService;

    @Test
    void testGetAllLivres() throws Exception {
        // Arrange
        Livre livre1 = new Livre();
        livre1.setId(1L);
        livre1.setTitle("Title 1");
        livre1.setAuthor("Author 1");

        Livre livre2 = new Livre();
        livre2.setId(2L);
        livre2.setTitle("Title 2");
        livre2.setAuthor("Author 2");

        when(livreService.findAll()).thenReturn(Arrays.asList(livre1, livre2));

        // Act & Assert
        mockMvc.perform(get("/livres"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].title").value("Title 1"))
                .andExpect(jsonPath("$[1].title").value("Title 2"));

        verify(livreService, times(1)).findAll();
    }
}