package com.curso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.model.Producto;

public interface ProductosRepository extends JpaRepository<Producto, Integer> {

}
