package com.agencia.hoteles.service;

import java.util.List;

import com.agencia.hoteles.model.Hotel;

public interface HotelService {
	
	// Método para obtener todos los hoteles disponibles
    List<Hotel> obtenerHotelesDisponibles();

    // Método para obtener un hotel por su nombre
    Hotel obtenerHotelPorNombre(String nombre);
}


