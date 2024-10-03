package com.curso.excepciones;

public class PrincipalTry {
	public static void main(String[] args) {
		
		String nombre = null;
		System.out.println(nombre);
		
		
		try {
			System.out.println(nombre.length());
		} catch (Exception e) {
			
			//e.printStackTrace();
		}
		
		
		System.out.println("Nos vamos"); 
	
}
}
