package com.curso.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Curso;
import com.curso.model.Estudiante;
import com.curso.repository.CursoRepository;
import com.curso.repository.EstudianteRepository;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;
    
    @Autowired
    private EstudianteRepository estudianteRepository;

    @GetMapping
    public List<Curso> getAllCursos() {
        return cursoRepository.findAll();
    }

    @PostMapping
    public Curso createCurso(@RequestBody Curso curso) {
        return cursoRepository.save(curso);
    }
    @PostMapping("/{cursoId}/inscribir/{estudianteId}")
    public ResponseEntity<String> inscribirEstudiante(@PathVariable Long cursoId, @PathVariable Long estudianteId) {
        Optional<Curso> cursoOptional = cursoRepository.findById(cursoId);
        Optional<Estudiante> estudianteOptional = estudianteRepository.findById(estudianteId);

        if (cursoOptional.isPresent() && estudianteOptional.isPresent()) {
            Curso curso = cursoOptional.get();
            Estudiante estudiante = estudianteOptional.get();

            curso.getEstudiantes().add(estudiante);
            estudiante.getCursos().add(curso);

            cursoRepository.save(curso);
            estudianteRepository.save(estudiante);

            return ResponseEntity.ok("Estudiante inscrito.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}