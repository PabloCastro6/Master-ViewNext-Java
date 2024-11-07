package com.agencia.reservas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.agencia.reservas.model.Reserva;
import com.agencia.reservas.service.ReservaService;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

	 @Autowired
	    private ReservaService reservaService;

	    // Endpoint para registrar una reserva
	    @PostMapping
	    public Reserva registrarReserva(@RequestBody Reserva reserva, @RequestParam int totalPersonas) {
	        return reservaService.registrarReserva(reserva, totalPersonas);
	    }

	    // Endpoint para obtener reservas por nombre de hotel
	    @GetMapping("/hotel/{nombreHotel}")
	    public List<Reserva> obtenerReservasPorHotel(@PathVariable String nombreHotel) {
	        return reservaService.obtenerReservasPorHotel(nombreHotel);
	    }
	}