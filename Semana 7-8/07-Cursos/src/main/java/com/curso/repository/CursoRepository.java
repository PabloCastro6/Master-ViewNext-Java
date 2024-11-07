package com.curso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Integer>{
	List<Curso> findByPrecioBetween(double precioMax, double precioMin);
}
