package com.curso.service;

import java.util.List;
import java.util.Optional;

import com.curso.model.Curso;

public interface CursoService {
	public List<Curso> getCursos();
	public Optional<Curso> buscarCurso(int codCurso);
	public List<Curso> alta(Curso curso);
	public List<Curso> eliminar(int codCurso);
	public void actualizar(int codCurso, int duracion);
	public List<Curso> findByPrecioBetween(double precioMin, double precioMax);
}
