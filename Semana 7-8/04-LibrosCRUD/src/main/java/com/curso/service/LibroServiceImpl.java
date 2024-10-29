package com.curso.service;

import java.util.ArrayList;
import java.util.List;

import com.curso.model.Libro;

public class LibroServiceImpl implements LibroService {
	public List<Libro> libros;
	
	public LibroServiceImpl() {
		libros = new ArrayList<Libro>(List.of(new Libro(1, "Grecia", "guia viaje"),
				new Libro(2,"Italia","guia viaje"),
				new Libro(3,"Perla Negra", "misterio"),
				new Libro(4,"Días de lluvia", "teatro")
				));
	}
	
	
	@Override
	public List<Libro> libros() {
		return libros;
	}

	@Override
	public Libro buscarLibro(int isbn) {
		
		return null;
	}

	@Override
	public void altaLibro(Libro libro) {
		
		
	}

	@Override
	public void actualizarLibro(Libro libro) {
		
		
	}

	@Override
	public List<Libro> eliminarLibro(int isbn) {
		
		return null;
	}

}
