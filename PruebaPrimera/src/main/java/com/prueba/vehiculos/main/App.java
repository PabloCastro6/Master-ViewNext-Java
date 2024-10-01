
package com.prueba.vehiculos.main;

import java.util.List;

import com.prueba.vehiculo.Camion;
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
		Coche miCoche = new Coche("ABC123", "Rojo");
		miCoche.arrancar(); // Hora de inicio del viaje
		miCoche.avanzar(35, 100);// Avanzo x metros a x km/hora
		System.out.println("Metros avanzados: " + miCoche.getMetrosRecorridos());
		miCoche.parar(); // Tiempo final del viaje
		
		System.out.println("==========");
		
		Camion camion = new Camion();
		camion.agregarVelocidad(60.0);
		camion.agregarVelocidad(80.0);
		camion.agregarVelocidad(100.0);

		List<Double> tacometro = camion.getTacometro();
		System.out.println("Tacómetro: " + tacometro);
	}

}