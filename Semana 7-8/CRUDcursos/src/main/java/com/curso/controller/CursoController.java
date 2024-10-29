package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.curso.model.Curso;
import com.curso.service.CursoService;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    // Recuperar todos los cursos
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Curso> obtenerCursos() {
        return cursoService.obtenerCursos();
    }

    // Buscar un curso por código
    @GetMapping(value = "/{codCurso}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Curso buscarCurso(@PathVariable int codCurso) {
        return cursoService.buscarCurso(codCurso);
    }

    // Alta de curso
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Curso> altaCurso(@RequestBody Curso curso) {
        return cursoService.altaCurso(curso);
    }

    // Actualización de duración
    @PutMapping(value = "/{codCurso}/{duracion}")
    public void actualizarDuracion(@PathVariable int codCurso, @PathVariable int duracion) {
        cursoService.actualizarDuracion(codCurso, duracion);
    }

    // Eliminar un curso por código
    @DeleteMapping(value = "/{codCurso}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Curso> eliminarCurso(@PathVariable int codCurso) {
        return cursoService.eliminarCurso(codCurso);
    }

    // Cursos por rango de precios
    @GetMapping(value = "/precio/{min}/{max}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Curso> cursosPorPrecio(@PathVariable double min, @PathVariable double max) {
        return cursoService.cursosPorPrecio(min, max);
    }
}
