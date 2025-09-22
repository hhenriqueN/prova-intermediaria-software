package com.example.prova_intermediaria_software.service;

import com.example.prova_intermediaria_software.dto.CursoDTO;
import com.example.prova_intermediaria_software.model.Curso;
import com.example.prova_intermediaria_software.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public Curso cadastrar(CursoDTO dto) {
        Curso curso = new Curso();
        curso.setTitulo(dto.titulo());
        curso.setDescricao(dto.descricao());
        curso.setCargaHoraria(dto.cargaHoraria());
        curso.setInstrutor(dto.instrutor());
        curso.setDataCadastro(LocalDate.now());

        return cursoRepository.save(curso);
    }

    public List<Curso> listar() {
        return cursoRepository.findAll();
    }

    public void excluir(Long id) {
        cursoRepository.deleteById(id);
    }
}
