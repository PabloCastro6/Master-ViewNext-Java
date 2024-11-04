package com.masterjava.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masterjava.model.Curso;

public interface ICursoRepository extends JpaRepository<Curso, Integer> {

}
