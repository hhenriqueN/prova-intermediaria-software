package com.example.prova_intermediaria_software.controller;

import com.example.prova_intermediaria_software.dto.CursoDTO;
import com.example.prova_intermediaria_software.model.Curso;
import com.example.prova_intermediaria_software.service.CursoService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CursoControllerTest {

    @Mock
    private CursoService cursoService;

    @InjectMocks
    private CursoController cursoController;

    public CursoControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveCadastrarCurso() {
        CursoDTO dto = new CursoDTO("Spring", "API", 20, "Maria");
        Curso curso = new Curso();
        curso.setId(1L);
        curso.setTitulo("Spring");
        when(cursoService.cadastrar(dto)).thenReturn(curso);

        Curso result = cursoController.cadastrar(dto);

        assertEquals("Spring", result.getTitulo());
    }

    @Test
    void deveListarCursos() {
        when(cursoService.listar()).thenReturn(List.of(new Curso()));
        assertFalse(cursoController.listar().isEmpty());
    }

    @Test
    void deveExcluirCurso() {
        doNothing().when(cursoService).excluir(1L);
        cursoController.excluir(1L);
        verify(cursoService, times(1)).excluir(1L);
    }
}
