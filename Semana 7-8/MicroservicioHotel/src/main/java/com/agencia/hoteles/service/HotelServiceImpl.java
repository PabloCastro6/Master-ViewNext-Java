package com.agencia.hoteles.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agencia.hoteles.model.Hotel;
import com.agencia.hoteles.repository.HotelRepository;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public List<Hotel> obtenerHotelesDisponibles() {
        return hotelRepository.findByDisponibleTrue();
    }

    @Override
    public Hotel obtenerHotelPorNombre(String nombre) {
        return hotelRepository.findByNombre(nombre);
    }
}
