
package com.prueba.vehiculos.main;

import com.prueba.vehiculo.Coche;

public class App {

	/**
	 * Método principal que ejecuta la aplicación. Crea un coche, lo arranca, avanza
	 * una cierta distancia y luego lo detiene, mostrando información sobre el
	 * viaje.
	 * 
	 * @param args Argumentos de línea de comandos.
	 */

	public static void main(String[] args) {
		Coche miCoche = new Coche("Rojo", "1234_ABC");
		miCoche.arrancar();
		miCoche.avanzar(6.0, 100); //Avanzar 6km a 100km/h
		miCoche.avanzar(10.0, 80);
		miCoche.parar();

	}

}
