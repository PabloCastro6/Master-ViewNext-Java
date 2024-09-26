package com.curos.estatic1;

public class Persona {
	private String nombre;  //variables de instancia
	private int edad;
	

	public Persona(String nombre, int edad) {
		super();
		this.nombre = nombre;
		this.edad = edad;
	}

	private static int contadorPersonas;  //Quiero tener el nº de personas ===> VARIABLE DE CLASE


	public static int getContadorPersonas() {
		return contadorPersonas;
	}


	public static void setContadorPersonas(int contadorPersonas) {
		Persona.contadorPersonas = contadorPersonas;
	}
	
	public static void incrementarContador() {
		contadorPersonas++;
	}

}
