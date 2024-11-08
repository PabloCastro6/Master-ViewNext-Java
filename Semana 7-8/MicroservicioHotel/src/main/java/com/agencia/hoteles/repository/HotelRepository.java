package com.agencia.hoteles.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agencia.hoteles.model.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {
	List<Hotel> findByDisponibleTrue();
    Hotel findByNombre(String nombre);
}
