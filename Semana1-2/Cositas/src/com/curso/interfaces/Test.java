package com.curso.interfaces;

public class Test {

	public static void main(String[] args) {
		ClaseUno c1 = new ClaseUno();
		c1.metodo();
		c1.metodoPorDefecto();
		Interfaz.metodoEstatico();
		System.out.println("**********");
		ClaseDos c2 = new ClaseDos();
		c2.metodo();
		c2.metodoPorDefecto();
		Interfaz.metodoEstatico();

	}

}
