package com.agencia.hoteles.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agencia.hoteles.model.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {
	 // Método para obtener hoteles disponibles
    List<Hotel> findByDisponibleTrue();

    // Método para obtener un hotel por nombre
    Hotel findByNombre(String nombre);

}
