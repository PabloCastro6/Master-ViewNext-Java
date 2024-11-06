package com.curso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.model.Libro;
import com.curso.repository.LibrosRepository;
@Service
public class LibroServiceImpl implements LibroService {
	@Autowired
	LibrosRepository repository;
	@Override
	public List<Libro> libros() {
		return repository.findAll();
	}

	@Override
	public Libro buscarLibro(int isbn) {
		return repository.findById(isbn).orElse(null);
	}

	@Override
	public void altaLibro(Libro libro) {
		repository.save(libro);
	}

	@Override
	public void actualizar(Libro libro) {
		repository.save(libro);
	}

	@Override
	public List<Libro> eliminar(int isbn) {
		repository.deleteById(isbn);
		return 	repository.findAll();
	}

	@Override
	public List<Libro> buscarPorTitulo(String titulo) {
		return repository.buscarPorTitulo(titulo);
	}

	@Override
	public List<Libro> findByTematica(String tematica) {
		return repository.findByTematica(tematica);
	}

}
