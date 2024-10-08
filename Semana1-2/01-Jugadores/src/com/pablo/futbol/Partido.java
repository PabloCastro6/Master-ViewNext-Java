package com.pablo.futbol;

public class Partido {
    private Equipo equipoLocal;
    private Equipo equipoVisitante;
    private int golesLocal;
    private int golesVisitante;

    public Partido(Equipo equipoLocal, Equipo equipoVisitante, int golesLocal, int golesVisitante) {
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.golesLocal = golesLocal;
        this.golesVisitante = golesVisitante;
    }

    public void jugarPartido() {
        if (golesLocal > golesVisitante) {
            equipoLocal.ganarPartido();
        } 
        if (golesVisitante > golesLocal) {
            equipoVisitante.ganarPartido();
        }
    }

    @Override
    public String toString() {
        return equipoLocal.getNombre() + " " + golesLocal + " - " + golesVisitante + " " + equipoVisitante.getNombre();
    }
}
