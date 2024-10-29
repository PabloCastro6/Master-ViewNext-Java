package com.curso.service;

import java.util.List;

import com.curso.model.Libro;

public interface LibroService {
	public List<Libro>libros();
	public Libro buscarLibro(int isbn);
	public void altaLibro(Libro libro);
	public void actualizarLibro(Libro libro);
	public List<Libro> eliminarLibro(int isbn);

}


