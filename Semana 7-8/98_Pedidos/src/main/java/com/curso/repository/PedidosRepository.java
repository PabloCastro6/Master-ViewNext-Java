package com.curso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.model.Pedido;

public interface PedidosRepository extends JpaRepository<Pedido, Integer> {

}
