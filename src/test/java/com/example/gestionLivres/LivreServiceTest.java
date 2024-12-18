package com.example.gestionLivres;

import com.example.gestionLivres.model.Livre;
import com.example.gestionLivres.repository.LivreRepository;
import com.example.gestionLivres.service.LivreService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;  // Correction ici
import static org.junit.jupiter.api.Assertions.*;

public class LivreServiceTest {

    @Mock
    private LivreRepository livreRepository;

    @InjectMocks
    private LivreService livreService;

    public LivreServiceTest() {
        MockitoAnnotations.openMocks(this);  // Initialisation des mocks
    }

    @Test
    void testFindAll() {
        // Arrange
        Livre livre1 = new Livre(1L, "Title 1", "Author 1");
        Livre livre2 = new Livre(2L, "Title 2", "Author 2");
        when(livreRepository.findAll()).thenReturn(Arrays.asList(livre1, livre2));

        // Act
        List<Livre> livres = livreService.findAll();

        // Assert
        assertEquals(2, livres.size());
        verify(livreRepository, times(1)).findAll();  // Correct usage of Mockito's verify
    }

    @Test
    void testFindById() {
        // Arrange
        Livre livre = new Livre(1L, "Title", "Author");
        when(livreRepository.findById(1L)).thenReturn(Optional.of(livre));

        // Act
        Livre result = livreService.findById(1L);

        // Assert
        assertNotNull(result);
        assertEquals("Title", result.getTitle());
        verify(livreRepository, times(1)).findById(1L);
    }


    @Test
    void testSave() {
        Livre livre = new Livre(null, "Title", "Author");
        when(livreRepository.save(livre)).thenReturn(new Livre(1L, "Title", "Author"));

        Livre result = livreService.save(livre);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        verify(livreRepository, times(1)).save(livre);  // Correct usage of Mockito's verify
    }

    @Test
    void testDeleteById() {
        livreService.deleteById(1L);

        verify(livreRepository, times(1)).deleteById(1L);  // Correct usage of Mockito's verify
    }
}
