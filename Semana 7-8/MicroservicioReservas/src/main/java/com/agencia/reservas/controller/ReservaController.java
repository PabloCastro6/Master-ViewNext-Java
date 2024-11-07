package com.agencia.reservas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.agencia.reservas.model.Reserva;
import com.agencia.reservas.service.ReservaService;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

	 @Autowired
	    private ReservaService reservaService;
	 
	 //PRUEBA
	 @Autowired
	 private RestTemplate restTemplate;

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
	    
	    
	    //PRUEBA 
	    @GetMapping("/test-conexion-vuelos/{idVuelo}")
	    public ResponseEntity<String> testConexionVuelos(@PathVariable Integer idVuelo) {
	        String url = "http://localhost:8081/vuelos/" + idVuelo;
	        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
	        return new ResponseEntity<>("Conexión exitosa con Vuelos: " + response.getBody(), HttpStatus.OK);
	    }
	}