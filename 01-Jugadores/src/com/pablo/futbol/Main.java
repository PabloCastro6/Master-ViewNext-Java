package com.pablo.futbol;

public class Main {
    public static void main(String[] args) {
        
        Liga liga = new Liga();

      
        Equipo equipo1 = new Equipo("Equipo A");
        Equipo equipo2 = new Equipo("Equipo B");

        
        liga.agregarEquipo(equipo1);
        liga.agregarEquipo(equipo2);

       
        equipo1.agregarJugador(new Jugador("Jugador 1", 5));
        equipo1.agregarJugador(new Jugador("Jugador 2", 3));

        equipo2.agregarJugador(new Jugador("Jugador 3", 4));
        equipo2.agregarJugador(new Jugador("Jugador 4", 2));

        
        Partido partido1 = new Partido(equipo1, equipo2, 2, 1);
        liga.agregarPartido(partido1);

        Partido partido2 = new Partido(equipo2, equipo1, 3, 0);
        liga.agregarPartido(partido2);

        
        System.out.println("Equipos por partidos ganados:");
        liga.listarEquiposPorPartidosGanados();

       
        System.out.println("Partidos jugados:");
        liga.listarPartidos();

        
        System.out.println("Jugadores de " + equipo1.getNombre() + " por goles:");
        equipo1.listarJugadoresPorGoles();

        
        System.out.println("Jugadores de " + equipo2.getNombre() + " por goles:");
        equipo2.listarJugadoresPorGoles();
    }
}
