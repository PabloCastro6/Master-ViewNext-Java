package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Libro;
import com.curso.service.LibroService;

@RestController
public class LibroController {
	@Autowired
	private LibroService libroService;
	
	@GetMapping(value="libros", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Libro> libros() {
		return libroService.libros();
		
	}
	
	@GetMapping(value="libros/{isbn}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Libro buscarLibro(@PathVariable int isbn) {
		return libroService.buscarLibro(isbn);
	}
	
	@PostMapping(value="libros", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void altaLibro(@RequestBody Libro libro) {
		libroService.altaLibro(libro);
	}
	
	@PutMapping (value="libros", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void actualizarLibro(@RequestBody Libro libro) {
		libroService.actualizarLibro(libro);
	}
	
	@DeleteMapping (value="libros/{isbn}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Libro> eliminarLibro(@PathVariable int isbn) {
		return libroService.eliminarLibro(isbn);
		
	}
}
