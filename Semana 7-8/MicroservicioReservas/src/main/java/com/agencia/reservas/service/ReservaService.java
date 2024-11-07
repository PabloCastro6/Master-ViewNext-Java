package com.agencia.reservas.service;

import java.util.List;

import com.agencia.reservas.model.Reserva;

public interface ReservaService {
	Reserva registrarReserva(Reserva reserva, int totalPersonas);
    List<Reserva> obtenerReservasPorHotel(String nombreHotel);

}
