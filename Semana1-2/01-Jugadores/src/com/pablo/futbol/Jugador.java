package com.pablo.futbol;

public class Jugador {
	private String nombre;
	private int goles;
	
	
	
	public Jugador (String nombre, int goles) {
		this.nombre = nombre;
		this.goles = goles;
	}
	
	public int getGoles() {
        return goles;
    }

    public String getNombre() {
        return nombre;
    }
    
	@Override 
	public String toString() {
		return nombre + ": " + goles + " goles";
		
	}
	
}

