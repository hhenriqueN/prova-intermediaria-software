package com.example.prova_intermediaria_software.controller;

import com.example.prova_intermediaria_software.dto.CursoDTO;
import com.example.prova_intermediaria_software.model.Curso;
import com.example.prova_intermediaria_software.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    // Criar curso
    @PostMapping
    public Curso cadastrar(@RequestBody CursoDTO dto) {
        return cursoService.cadastrar(dto);
    }

    // Listar cursos
    @GetMapping
    public List<Curso> listar() {
        return cursoService.listar();
    }

    // Excluir curso por ID
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        cursoService.excluir(id);
    }
}
