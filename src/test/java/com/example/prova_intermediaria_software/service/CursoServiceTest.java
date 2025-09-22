package com.example.prova_intermediaria_software.service;

import com.example.prova_intermediaria_software.dto.CursoDTO;
import com.example.prova_intermediaria_software.model.Curso;
import com.example.prova_intermediaria_software.repository.CursoRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CursoServiceTest {

    @Mock
    private CursoRepository cursoRepository;

    @InjectMocks
    private CursoService cursoService;

    public CursoServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveCadastrarCurso() {
        CursoDTO dto = new CursoDTO("Java", "Basico", 10, "João");
        Curso salvo = new Curso();
        salvo.setId(1L);
        salvo.setTitulo("Java");
        when(cursoRepository.save(any(Curso.class))).thenReturn(salvo);

        Curso resultado = cursoService.cadastrar(dto);

        assertNotNull(resultado.getId());
        assertEquals("Java", resultado.getTitulo());
    }

    @Test
    void deveListarCursos() {
        when(cursoRepository.findAll()).thenReturn(List.of(new Curso()));
        assertFalse(cursoService.listar().isEmpty());
    }

    @Test
    void deveExcluirCurso() {
        doNothing().when(cursoRepository).deleteById(1L);
        cursoService.excluir(1L);
        verify(cursoRepository, times(1)).deleteById(1L);
    }
}
