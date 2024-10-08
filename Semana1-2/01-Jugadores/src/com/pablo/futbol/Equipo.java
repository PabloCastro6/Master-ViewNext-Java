package com.pablo.futbol;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Equipo {
    private String nombre;
    private int partidosGanados;
    private ArrayList<Jugador> jugadores;

    public Equipo(String nombre) {
        this.nombre = nombre;
        this.partidosGanados = 0;
        this.jugadores = new ArrayList<>();
    }

    
    public void agregarJugador(Jugador jugador) {
        jugadores.add(jugador);
    }

    public void ganarPartido() {
        partidosGanados++;
    }

    public int getPartidosGanados() {
        return partidosGanados;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    // Ordenar jugadores por goles marcados
    public void listarJugadoresPorGoles() {
      Collections.sort(jugadores, Comparator.comparingInt(Jugador::getGoles).reversed());
        for (Jugador jugador : jugadores) {
            System.out.println(jugador);
        }
    }
    
    @Override
    public String toString() {
        return nombre + " - Partidos Ganados: " + partidosGanados;
    }
}
