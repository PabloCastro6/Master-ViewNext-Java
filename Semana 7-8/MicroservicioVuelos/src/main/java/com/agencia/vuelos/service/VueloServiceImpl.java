package com.agencia.vuelos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agencia.vuelos.model.Vuelo;
import com.agencia.vuelos.repository.VueloRepository;

@Service
public class VueloServiceImpl implements VueloService {

	@Autowired
    private VueloRepository vueloRepository;

    @Override
    public List<Vuelo> obtenerVuelosDisponibles(Integer plazasRequeridas) {
        return vueloRepository.findByPlazasDisponiblesGreaterThanEqual(plazasRequeridas);
    }

    @Override
    public void actualizarPlazasVuelo(Integer idVuelo, Integer plazasReservadas) {
        Vuelo vuelo = vueloRepository.findById(idVuelo)
                .orElseThrow(() -> new RuntimeException("Vuelo no encontrado"));
        vuelo.setPlazasDisponibles(vuelo.getPlazasDisponibles() - plazasReservadas);
        vueloRepository.save(vuelo);

	}

}
