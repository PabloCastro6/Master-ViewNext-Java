package com.agencia.hoteles.service;

import java.util.List;

import com.agencia.hoteles.model.Hotel;

public interface HotelService {

	List<Hotel> obtenerHotelesDisponibles();
    Hotel obtenerHotelPorNombre(String nombre);
}
