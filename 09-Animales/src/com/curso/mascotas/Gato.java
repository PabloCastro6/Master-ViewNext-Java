package com.curso.mascotas;

import com.curso.animales.Animal;

public class Gato extends Animal implements Mascota {
	private String nombre;
	
	public Gato(String nombre) {
		super(4);
		this.nombre = nombre;
	}
	
	@Override 
	public void comer() {
		System.out.println("A los gatos les gusta comer peces y arañas");
	}
	
	@Override
	public void jugar() {
		System.out.println("A " + nombre + " le gusta jugar con pelotas");
	}

	@Override
	public String getNombre() {
		return nombre;
	}

	@Override
	public void setNombre(String nombre) {
		this.nombre = nombre;
		
	}
	

}
