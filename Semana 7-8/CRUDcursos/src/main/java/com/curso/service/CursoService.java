package com.curso.service;

import java.util.List;

import com.curso.model.Curso;

public interface CursoService {

    public List<Curso> obtenerCursos();
    public Curso buscarCurso(int codCurso);
    public List<Curso> altaCurso(Curso curso);
    public void actualizarDuracion(int codCurso, int duracion);
    public List<Curso> eliminarCurso(int codCurso);
    public List<Curso> cursosPorPrecio(double min, double max);
}
