package com.curso.interfaces;

public class ClaseDos implements Interfaz {

	@Override
	public void metodo() {
		System.out.println("Hola desde el metodo de ClaseDos ");

	}

	@Override
	public void metodoPorDefecto() {
		Interfaz.super.metodoPorDefecto();
		System.out.println("Yo soy la implementacion ");
	}

}
