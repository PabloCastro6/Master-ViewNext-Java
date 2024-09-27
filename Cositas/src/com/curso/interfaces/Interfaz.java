package com.curso.interfaces;

public interface Interfaz {
	public void metodo();
	//Este es un metodo default. Estos metodos se pueden sobreescribir
	//Metodos default tienen que tener una implementacion expecifica
	default public void metodoPorDefecto() {
		System.out.println("Soy un metodo por defecto de la interfaz Interfaz");
		
	}
	//Metodo estatico. No se puede sobreescribir
	public static void metodoEstatico() {
		System.out.println("Soy un metodo estatico de la interfaz Interfaz");
	}

}
