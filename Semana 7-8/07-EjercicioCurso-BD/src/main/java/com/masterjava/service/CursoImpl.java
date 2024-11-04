package com.masterjava.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masterjava.model.Curso;
import com.masterjava.repository.ICursoRepository;

@Service
/**
 * Clase Impl que implementa los métodos de la interfaz ICurso.
 * 
 * @author Pablo Castro Morato
 * @version 1.0 31/10/2024
 */
public class CursoImpl implements ICurso {
	@Autowired
	private ICursoRepository repository;

	@Override
	/**
	 * Método que muestra todos los cursos disponibles.
	 * 
	 * @return lista de todos los cursos.
	 */
	public List<Curso> listarCursos() {
		return repository.findAll();
	}

	@Override
	/**
	 * Método que da de alta un nuevo curso.
	 * 
	 * @param curso El curso que va a ser dado de alta.
	 * @return lista de todos los cursos incluido el nuevo.
	 */
	public List<Curso> altaCurso(Curso curso) {
		if (!repository.existsById(curso.getCodCurso())) {
			repository.save(curso);
		}
		return repository.findAll();
	}

	@Override
	/**
	 * Método que elimina un curso.
	 * 
	 * @param codCurso el codigo del curso que va a ser eliminado.
	 * @return lista de todos los cursos sin el curso eliminado.
	 */
	public List<Curso> bajaCurso(int codCurso) {
		repository.deleteById(codCurso);
		return repository.findAll();
	}

	@Override
	/**
	 * Método que cambia la duración de un curso.
	 * 
	 * @param codCurso el código del curso que va a ser actualizado
	 * @param duracion la nueva duración del curso
	 */
	public void actualizarDuracion(int codCurso, int duracion) {
		 Curso curso = repository.findById(codCurso).orElse(null);
		    if (curso != null && duracion > 0) { // Verifica que el curso exista y la duración sea válida
		        curso.setDuracion(duracion);
		        repository.save(curso);
		    } else {
		        throw new RuntimeException("Curso no encontrado o duración inválida");
		    }
		}

	@Override
	/**
	 * Método que busca un curso de la lista de cursos.
	 * 
	 * @param codCurso el código del curso que solicita.
	 * @return los datos del curso buscado.
	 */
	public Curso buscarCurso(int codCurso) {
		return repository.findById(codCurso).orElse(null);
	}

	@Override
	/**
	 * Método que lista cursos entre un rango de precios.
	 * 
	 * @param precioMin el precio mínimo del rango
	 * @param precioMax el precio máximo del rango.
	 * @return lista de cursos entre el rango de precios especificados.
	 */
	public List<Curso> listarCursosPorRangoPrecio(int precioMin, int precioMax) {
		return repository.findAll().stream()
	            .filter(curso -> curso.getPrecio() >= precioMin && curso.getPrecio() <= precioMax)
	            .collect(Collectors.toList());
	}
}
