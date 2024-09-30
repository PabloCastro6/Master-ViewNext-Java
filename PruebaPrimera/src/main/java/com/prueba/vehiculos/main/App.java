package com.prueba.vehiculos.main;

import com.prueba.vehiculo.Coche;

public class App {
	
	 /**
     * Método principal que ejecuta la aplicación. Crea un coche, lo arranca,
     * avanza una cierta distancia y luego lo detiene, mostrando información
     * sobre el viaje.
     * 
     * @param args Argumentos de línea de comandos.
     */

	public static void main(String[] args) {
		Coche miCoche = new Coche("Rojo", "1234_ABC");
		miCoche.arrancar();
		miCoche.avanzar(12, 30.9);
		miCoche.parar();

	}

}
