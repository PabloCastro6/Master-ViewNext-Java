package com.masterjava.service;

import java.util.List;

import com.masterjava.model.Curso;

/**
 * Interfaz que implementa métodos CRUD para la clase Curso.
 * 
 * @author Pablo Guijarro Pérez
 * @version 1.0 31/10/2024
 */
public interface ICurso {

	public List<Curso> listarCursos();

	public List<Curso> altaCurso(Curso curso);

	public List<Curso> bajaCurso(int codCurso);

	public void actualizarDuracion(int codCurso, int duracion);

	public Curso buscarCurso(int codCurso);

	public List<Curso> listarCursosPorRangoPrecio(int precioMin, int precioMax);

}
