package com.curso.formacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.formacion.model.Formacion;

public interface FormacionRepository extends JpaRepository<Formacion, Long> {
    boolean existsByCurso(String curso);
}
