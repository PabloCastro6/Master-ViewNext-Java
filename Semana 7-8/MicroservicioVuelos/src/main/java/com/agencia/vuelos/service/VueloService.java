package com.agencia.vuelos.service;

import java.util.List;

import com.agencia.vuelos.model.Vuelo;

public interface VueloService {
    List<Vuelo> obtenerVuelosDisponibles(Integer plazasRequeridas);
    void actualizarPlazasVuelo(Integer idVuelo, Integer plazasReservadas);
}

