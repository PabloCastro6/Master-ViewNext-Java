package com.agencia.vuelos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agencia.vuelos.model.Vuelo;

public interface VueloRepository extends JpaRepository<Vuelo, Integer> {
    List<Vuelo> findByPlazasDisponiblesGreaterThanEqual(Integer plazasRequeridas);
}

