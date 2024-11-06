package com.curso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.curso.model.Libro;

public interface LibrosRepository extends JpaRepository<Libro, Integer> {
	
	@Query("SELECT l FROM Libro l WHERE l.titulo = :titulo")
	List<Libro> buscarPorTitulo(String titulo);	
	
	List<Libro> findByTematica(String tematica);

}
