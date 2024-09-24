package com.cursojava.cafeteria;

public class Main {
	public static void main(String[] args) {
 Cafetera cafetera = new Cafetera();
 
 cafetera.llenarCafetera();
 System.out.println("Cantidad actual: " + cafetera.getCantidadActual() + " c.c.");

 // Servir una taza de 150 c.c.
 cafetera.servirTaza(150);
 System.out.println("Cantidad actual después de servir: " + cafetera.getCantidadActual() + " c.c.");

 // Agregar 200 c.c. de café
 cafetera.agregarCafe(200);
 System.out.println("Cantidad actual después de agregar: " + cafetera.getCantidadActual() + " c.c.");

 // Vaciar la cafetera
 cafetera.vaciarCafetera();
 System.out.println("Cantidad actual después de vaciar: " + cafetera.getCantidadActual() + " c.c.");
}
}