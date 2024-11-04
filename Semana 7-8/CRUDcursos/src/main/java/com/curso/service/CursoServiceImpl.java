package com.curso.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Service;

import com.curso.model.Curso;

/**
 * Implementación de la interfaz CursoService para gestionar cursos.
 */
@Service
public class CursoServiceImpl implements CursoService {

    private List<Curso> cursos;

    /**
     * Constructor que inicializa una lista de cursos de ejemplo.
     */
    public CursoServiceImpl() {
        cursos = new ArrayList<>(List.of(
            new Curso(1, "Java Básico", 40, 200.0),
            new Curso(2, "Spring Boot", 60, 350.0),
            new Curso(3, "Angular", 45, 300.0)
        ));
    }

    @Override
    public List<Curso> obtenerCursos() {
        return cursos;
    }

    @Override
    public Curso buscarCurso(int codCurso) {
        for (Curso curso : cursos) {
            if (curso.getCodCurso() == codCurso) {
                return curso;
            }
        }
        return null;
    }

    @Override
    public List<Curso> altaCurso(Curso curso) {
        if (!cursos.contains(curso)) {
            cursos.add(curso);
        }
        return cursos;
    }

    @Override
    public void actualizarDuracion(int codCurso, int duracion) {
        Curso curso = buscarCurso(codCurso);
        if (curso != null) {
            curso.setDuracion(duracion);
        }
    }
    
    

    @Override
    public List<Curso> eliminarCurso(int codCurso) {
        cursos.removeIf(curso -> curso.getCodCurso() == codCurso);
        return cursos;
    }

    @Override
    public List<Curso> cursosPorPrecio(double min, double max) {
        List<Curso> cursosEnRango = new ArrayList<>();
        for (Curso curso : cursos) {
            if (curso.getPrecio() >= min && curso.getPrecio() <= max) {
                cursosEnRango.add(curso);
            }
        }
        return cursosEnRango;
    }
}
