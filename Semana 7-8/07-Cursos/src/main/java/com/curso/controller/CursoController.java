package com.curso.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Curso;
import com.curso.service.CursoService;

@RestController
public class CursoController {
	@Autowired
	CursoService service;

	@GetMapping(value = "cursos", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> getCursos() {
		return service.getCursos();
	}

	@GetMapping(value = "cursos/{codCurso}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Optional<Curso> buscarCurso(@PathVariable int codCurso) {
		return service.buscarCurso(codCurso);
	}

	@PostMapping(value = "cursos", consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> alta(@RequestBody Curso curso) {
		service.alta(curso);
		return service.getCursos();
	}

	@DeleteMapping(value = "cursos/{codCurso}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> eliminar(@PathVariable int codCurso) {
		service.eliminar(codCurso);
		return service.getCursos();
	}

	@PutMapping(value = "cursos/{codCurso}/{duracion}")
	public void actualizar(@PathVariable int codCurso, @PathVariable int duracion) {
		service.actualizar(codCurso, duracion);
	}

	@GetMapping(value = "cursos/{precioMin}/{precioMax}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> findByPrecioBetween(@PathVariable double precioMax, @PathVariable double precioMin) {
		return service.findByPrecioBetween(precioMax, precioMin);
	}
}
