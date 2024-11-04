package com.curso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.curso.model.Libro;
import com.curso.repository.LibrosRepository;

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
		// TODO Auto-generated method stub
		return repository.findAll();
	}

}
