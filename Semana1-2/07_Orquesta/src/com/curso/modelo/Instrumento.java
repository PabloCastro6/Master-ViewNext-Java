package com.curso.modelo;

public abstract class Instrumento {
	protected String nombre;
	protected String tipo;
	
	
	public Instrumento(String nombre, String tipo) {
		this.nombre = nombre;
		this.tipo = tipo;
	}
	
	public void tocar() {
		System.out.println("Tocando el instrumento " + nombre);
		
	}
	
	public void afinar() {
		System.out.println("Afinando el instrumento " + nombre);
		
	}



}
