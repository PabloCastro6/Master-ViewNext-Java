package com.agencia.hoteles.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agencia.hoteles.model.Hotel;
import com.agencia.hoteles.service.HotelService;

@RestController
@RequestMapping("/hoteles")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    // Endpoint para obtener la lista de hoteles disponibles
    @GetMapping("/disponibles")
    public List<Hotel> obtenerHotelesDisponibles() {
        return hotelService.obtenerHotelesDisponibles();
    }

    // Endpoint para obtener un hotel por nombre
    @GetMapping("/{nombre}")
    public Hotel obtenerHotelPorNombre(@PathVariable String nombre) {
        return hotelService.obtenerHotelPorNombre(nombre);
    }
}
