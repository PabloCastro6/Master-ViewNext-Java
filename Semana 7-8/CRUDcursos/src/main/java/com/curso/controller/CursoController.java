package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.curso.model.Curso;
import com.curso.service.CursoService;


/**
 * Controlador REST para gestionar cursos.
 */
@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    /**
     * Recupera todos los cursos.
     * @return Lista de todos los cursos.
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Curso> obtenerCursos() {
        return cursoService.obtenerCursos();
    }

    /**
     * Busca un curso por su código.
     * @param codCurso Código del curso.
     * @return Curso encontrado o null si no existe.
     */
    @GetMapping(value = "/{codCurso}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Curso buscarCurso(@PathVariable int codCurso) {
        return cursoService.buscarCurso(codCurso);
    }

    /**
     * Da de alta un nuevo curso.
     * @param curso Curso a agregar.
     * @return Lista actualizada de cursos.
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Curso> altaCurso(@RequestBody Curso curso) {
        return cursoService.altaCurso(curso);
    }

    /**
     * Actualiza la duración de un curso específico.
     * @param codCurso Código del curso.
     * @param duracion Nueva duración en horas.
     */
    @PutMapping(value = "/{codCurso}/{duracion}")
    public void actualizarDuracion(@PathVariable int codCurso, @PathVariable int duracion) {
        cursoService.actualizarDuracion(codCurso, duracion);
    }

    /**
     * Elimina un curso por su código.
     * @param codCurso Código del curso.
     * @return Lista actualizada de cursos.
     */
    @DeleteMapping(value = "/{codCurso}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Curso> eliminarCurso(@PathVariable int codCurso) {
        return cursoService.eliminarCurso(codCurso);
    }

    /**
     * Recupera los cursos cuyo precio está en el rango especificado.
     * @param min Precio mínimo.
     * @param max Precio máximo.
     * @return Lista de cursos en el rango de precios.
     */
    @GetMapping(value = "/precio/{min}/{max}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Curso> cursosPorPrecio(@PathVariable double min, @PathVariable double max) {
        return cursoService.cursosPorPrecio(min, max);
    }
}
