package com.curso.service;

import java.util.List;

import com.curso.model.Libro;

public interface LibroService {
	List<Libro> libros();
	Libro buscarLibro(int isbn);
	void altaLibro(Libro libro);
	void actualizar(Libro libro);
	List<Libro> eliminar(int isbn);
	//Método de query incorporada en LibrosRepository
	List<Libro> buscarPorTitulo(String titulo);
	List<Libro> findByTematica(String tematica);
}
