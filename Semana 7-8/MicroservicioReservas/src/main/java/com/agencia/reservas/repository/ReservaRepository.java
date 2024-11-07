package com.agencia.reservas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agencia.reservas.model.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Integer> {
    // Método personalizado para encontrar reservas por idHotel
    List<Reserva> findByIdHotel(Integer idHotel);
}
