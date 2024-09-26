package com.curso.estatic2;

public class Persona {

	private String nombre;  //variables de instancia
	private int edad;
	private static int contPersonas;
	

	public Persona() {
		super();
		contPersonas++;
	}


	public Persona(String nombre, int edad) {
		super();
		this.nombre = nombre;
		this.edad = edad;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}


	public static int getContPersonas() {
		return contPersonas;
	}


	public static void setContPersonas(int contPersonas) {
		Persona.contPersonas = contPersonas;
	}


	
	
	
}
