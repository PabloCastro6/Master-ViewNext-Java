package com.masterjava.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masterjava.model.Curso;
import com.masterjava.service.ICurso;

@RestController
/**
 * Clase controladora que inicializa los métodos de la interfaz ICurso y los
 * mapea.
 * 
 * @author Pablo Castro Morato
 * @version 1.0 31/10/2024
 */
public class CursoController {
	@Autowired
	private ICurso iCurso;

	@GetMapping(value = "cursos", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> listarCursos() {
		return iCurso.listarCursos();
	}

	@GetMapping(value = "cursos/{codCurso}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Curso buscarCurso(@PathVariable int codCurso) {
		return iCurso.buscarCurso(codCurso);
	}

	@PostMapping(value = "cursos", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> altaCurso(@RequestBody Curso curso) {
		return iCurso.altaCurso(curso);
	}

	@DeleteMapping(value = "cursos/{codCurso}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> bajaCurso(@PathVariable int codCurso) {
		return iCurso.bajaCurso(codCurso);
	}

	@PutMapping(value = "cursos/{codCurso}/{duracion}")
	public ResponseEntity<String> actualizarDuracion(@PathVariable int codCurso, @PathVariable int duracion) {
		try {
	        iCurso.actualizarDuracion(codCurso, duracion);
	        return ResponseEntity.ok("Duración actualizada correctamente");
	    } catch (RuntimeException e) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: " + e.getMessage());
	    }
	}

	@GetMapping(value = "cursos/{precioMin}/{precioMax}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Curso>> listarCursosPorRangoPrecio(@PathVariable int precioMin, @PathVariable int precioMax) {
	    if (precioMin > precioMax) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	    }
	    return ResponseEntity.ok(iCurso.listarCursosPorRangoPrecio(precioMin, precioMax));
	}


}
