package com.agencia.reservas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.agencia.reservas.model.Reserva;
import com.agencia.reservas.repository.ReservaRepository;

@Service
public class ReservaServiceImpl implements ReservaService {

	
	@Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private RestTemplate restTemplate;
    
    @Override
    public Reserva registrarReserva(Reserva reserva, int totalPersonas) {
        // Lógica para registrar una reserva y actualizar las plazas en el microservicio de vuelos
        String urlVuelos = "http://localhost:8081/vuelos/" + reserva.getIdVuelo() + "/plazas?totalPersonas=" + totalPersonas;
        restTemplate.put(urlVuelos, null);  // Actualiza plazas en el microservicio de vuelos

        return reservaRepository.save(reserva);
    }

    @Override
    public List<Reserva> obtenerReservasPorHotel(String nombreHotel) {
        // Lógica para obtener idHotel desde el microservicio de hoteles
        String urlHoteles = "http://localhost:8082/hoteles/" + nombreHotel;
        Integer idHotel = restTemplate.getForObject(urlHoteles, Integer.class);

        return reservaRepository.findByIdHotel(idHotel);
    }
}
