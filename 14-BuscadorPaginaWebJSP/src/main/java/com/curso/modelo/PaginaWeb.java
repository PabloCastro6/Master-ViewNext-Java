package com.curso.modelo;

public class PaginaWeb {

	private String direccion;
	private String tematica;
	private String descripcion;

	public PaginaWeb(String direccion, String tematica, String descripcion) {
		this.direccion = direccion;
		this.tematica = tematica;
		this.descripcion = descripcion;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getTematica() {
		return tematica;
	}

	public String getDescripcion() {
		return descripcion;
	}
}
