package com.curso.estatic2;

public class Test {
	 public static void main(String[]args) {
		 Persona p1 = new Persona ("Eva" , 29);
		 Persona p2 = new Persona ("Ana" , 25);
		 Persona p3 = new Persona ("Iria" , 62);
		 Persona p4 = new Persona ("Lis" , 48);
		 
		 System.out.println("Se han creado" + Persona.getContPersonas() + " instancias");
		
	}

}
