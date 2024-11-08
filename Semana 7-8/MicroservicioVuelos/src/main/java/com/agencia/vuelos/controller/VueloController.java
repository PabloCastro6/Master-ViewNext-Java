package com.agencia.vuelos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.agencia.vuelos.model.Vuelo;
import com.agencia.vuelos.service.VueloService;

@RestController
@RequestMapping("/vuelos")
public class VueloController {

	@Autowired
	private VueloService vueloService;

	// Endpoint para obtener la lista de vuelos disponibles
	@GetMapping
	public List<Vuelo> obtenerVuelosDisponibles(@RequestParam Integer plazas) {
		return vueloService.obtenerVuelosDisponibles(plazas);
	}

	// Endpoint para actualizar las plazas de un vuelo
	@PutMapping("/{idVuelo}/plazas")
	public void actualizarPlazas(@PathVariable Integer idVuelo, @RequestParam Integer plazasReservadas) {
		vueloService.actualizarPlazasVuelo(idVuelo, plazasReservadas);
	}
	
	@GetMapping("/test")
	public String testEndpoint() {
	    return "El microservicio de vuelos está funcionando en el puerto 8081";
	}
}