package com.curso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}