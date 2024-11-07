package com.agencia.hoteles.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agencia.hoteles.model.Hotel;
import com.agencia.hoteles.repository.HotelRepository;

@RestController
@RequestMapping("/hoteles")
public class HotelController {
	
	@Autowired
    private HotelRepository hotelRepository;

    // Endpoint para obtener la lista de hoteles disponibles
    @GetMapping
    public List<Hotel> obtenerHotelesDisponibles() {
        return hotelRepository.findByDisponibleTrue();
    }

}
