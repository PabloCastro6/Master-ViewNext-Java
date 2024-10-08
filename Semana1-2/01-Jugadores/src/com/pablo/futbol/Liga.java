package com.pablo.futbol;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class Liga {
    private ArrayList<Equipo> equipos = new ArrayList<>();
    private ArrayList<Partido> partidos = new ArrayList<>();

    public void agregarEquipo(Equipo equipo) {
        equipos.add(equipo);
    }

    public void agregarPartido(Partido partido) {
        partidos.add(partido);
        partido.jugarPartido();
    }

    // Lista de equipos ordenados por partidos ganados
    public void listarEquiposPorPartidosGanados() {
        Collections.sort(equipos, Comparator.comparingInt(Equipo::getPartidosGanados).reversed());
        for (Equipo equipo : equipos) {
            System.out.println(equipo);
        }
    }

    // Lista de partidos jugados con resultados
    public void listarPartidos() {
        for (Partido partido : partidos) {
            System.out.println(partido);
        }
    }
}
