package com.curos.estatic1;

public class Test {

	public static void main(String[] args) {
		
		Persona p1 = new Persona("Pepito", 22);
		
		Persona.incrementarContador(); //Como es una variable de clase accedo a ella usando la clase
		
		
		Persona p2 = new Persona("Ana", 53);
		
		Persona.incrementarContador(); //incrementarContador es un metodo estatico 
		//Si no respeto recomendaciones de nombrado de clase
		//persona.incrementarContador();
		
		System.out.println("Se han creado " + Persona.getContadorPersonas() + " personas.");
		
		
		//PERO tambien puedo hacer pero NO RECOMENDABLE
		
		Persona p3 = new Persona("Juanito", 79);
		p3.incrementarContador();
		System.out.println("Compruebo el valor del contado de personas " + Persona.getContadorPersonas());
		System.out.println("Compruebo haciendo contador de personas " + p3.getContadorPersonas());

		
		
		

	}

}
