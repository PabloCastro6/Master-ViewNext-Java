package com.curso.colegio;

public class Principal {
public static void main(String[] args) {
	Nota nota1 = new Nota(8, "lengua");
	Nota nota2 = new Nota(7, "lengua");

	
	System.out.println(nota1.esMismaAsignatura(nota2));
}
}
