package com.curso.formacion.model;

import java.math.BigDecimal;

public class CursoAux {
	private String nombre;
	private int duracion; // Duración en horas
	private BigDecimal precio; // Precio del curso

	public CursoAux() {
		super();
	}

	public CursoAux(String nombre, int duracion, BigDecimal precio) {
		super();
		this.nombre = nombre;
		this.duracion = duracion;
		this.precio = precio;
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

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "CursoAux [nombre=" + nombre + ", duracion=" + duracion + ", precio=" + precio + "]";
	}

}
