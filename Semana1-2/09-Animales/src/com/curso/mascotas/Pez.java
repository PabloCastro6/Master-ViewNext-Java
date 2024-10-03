package com.curso.mascotas;

import com.curso.animales.Animal;

public class Pez extends Animal implements Mascota { 
	private String nombre;
	
	public Pez(String nombre) {
		super(0);
		this.nombre = nombre;
	}
	
	@Override
	public void comer()  {
		System.out.println("Los peces comen plancton");
	}
	
	@Override
	public void jugar() {
		System.out.println("Estoy nadando");
	}
	
	@Override
	public void andar() {
		System.out.println("En realidad no ando,nado");
	}

	public String getNombre() {
		return nombre;
	}

	@Override
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

}
