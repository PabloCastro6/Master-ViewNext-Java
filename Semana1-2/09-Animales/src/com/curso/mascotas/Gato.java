package com.curso.mascotas;
/**
 *Clase gato 
 *
 *@author Pablo Castro
 *@version 1.0 26/09/2024
 */

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
