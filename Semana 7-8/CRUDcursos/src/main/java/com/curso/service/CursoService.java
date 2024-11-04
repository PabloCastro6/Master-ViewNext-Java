package com.curso.service;

import java.util.List;

import com.curso.model.Curso;

public interface CursoService {

	/**
	 * Interfaz que define las operaciones de negocio para la gestión de cursos
	 */
	
	/**
     * Obtiene todos los cursos.
     * @return Lista de todos los cursos.
     */
    public List<Curso> obtenerCursos();
    
    /**
     * Busca un curso por su código.
     * @param codCurso Código del curso.
     * @return Curso encontrado o null si no existe.
     */
    public Curso buscarCurso(int codCurso);
    
    
    /**
     * Agrega un nuevo curso.
     * @param curso Curso a agregar.
     * @return Lista actualizada de cursos.
     */
    public List<Curso> altaCurso(Curso curso);
    
    
    /**
     * Actualiza la duración de un curso específico.
     * @param codCurso Código del curso.
     * @param duracion Nueva duración en horas.
     */
    public void actualizarDuracion(int codCurso, int duracion);
    
    
    /**
     * Elimina un curso por su código.
     * @param codCurso Código del curso.
     * @return Lista actualizada de cursos.
     */
    public List<Curso> eliminarCurso(int codCurso);
    
    
    
    /**
     * Obtiene los cursos cuyo precio está en un rango.
     * @param min Precio mínimo.
     * @param max Precio máximo.
     * @return Lista de cursos en el rango de precios.
     */
    public List<Curso> cursosPorPrecio(double min, double max);
}
