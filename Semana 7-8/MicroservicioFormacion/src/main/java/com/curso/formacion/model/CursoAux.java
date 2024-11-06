package com.curso.formacion.model;

public class CursoAux {
	private String nombre;
    private int duracion; // Duración en horas
    
	public CursoAux() {
		super();
	}
	public CursoAux(String nombre, int duracion) {
		super();
		this.nombre = nombre;
		this.duracion = duracion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	
	@Override
	public String toString() {
		return "Curso [nombre=" + nombre + ", duracion=" + duracion + "]";
	}
    
    

}
