package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Libro;
import com.curso.service.LibroService;

@RestController
public class LibroController {
	@Autowired
	LibroService libroService;
	
	public List<Libro> libros() {
		return libroService.libros();
	}

	public Libro buscarLibro(int sbn) {
		return libroService.buscarLibro(isbn);
	}
}
