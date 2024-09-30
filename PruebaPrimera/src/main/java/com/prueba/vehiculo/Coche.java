package com.prueba.vehiculo;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.prueba.vehiculo.interfaces.Conducible;
import com.prueba.vehiculos.model.Vehiculo;

/**
 * class Coche
 * @author Pablo Castro
 * @version 1.0, 30 sept 2024 
 */


/**
 * Clase que representa un coche, heredando de la clase Vehiculo y 
 * implementando la interfaz Conducible. Define características específicas
 * de un coche, como la matrícula y el número de ruedas.
 */

public class Coche extends Vehiculo implements Conducible {

	private final String matricula;
    private static final int NUMERO_RUEDAS = 4;
    private double distanciaRecorridaKm = 0; // Distancia recorrida en kilómetros
    private LocalDateTime inicioViaje;  // Hora de inicio del viaje
    private LocalDateTime finViaje;     // Hora de fin del viaje
   
	
	
	/**
     * Constructor que inicializa un coche con un color y una matrícula específicos.
     * 
     * @param color El color del coche.
     * @param matricula La matrícula del coche (inmutable).
     */
	public Coche(String color, String matricula) {
		super(color);
		this.matricula = matricula;
	}
	
    /**
     * Método que inicia el viaje del coche, registrando el tiempo inicial y
     * estableciendo una velocidad inicial predeterminada.
     */
	 @Override
	    public void arrancar() {
	        inicioViaje = LocalDateTime.now();  // Guardamos la hora de inicio
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");  // Formato de la hora
	        System.out.println(" Tiempo inicial del viaje: " + inicioViaje.format(formatter));
	    }
	 
	 @Override
	    public void avanzar(double kmAvanzados, int velocidad) {
	        distanciaRecorridaKm += km;  // Incrementamos la distancia en kilómetros

	        // Usamos Duration.between para calcular el tiempo transcurrido en minutos
	        Duration duracion = Duration.between(inicioViaje, LocalDateTime.now());
	        double tiempoActualMin = duracion.toMillis() / 60000.0;  // Convertimos el tiempo actual a minutos

	        System.out.println(" Avanzo " + km + " km. Tiempo actual de viaje: " + String.format("%.2f", tiempoActualMin) + " minutos.");
	    }
    
    /**
     * Método que detiene el coche, registrando el tiempo final del viaje y calculando
     * el espacio recorrido, el tiempo de viaje y la velocidad media.
     */
	 @Override
	    public void parar() {
	        finViaje = LocalDateTime.now();  // Guardamos la hora de detención

	        // Calculamos la duración total del viaje
	        Duration duracion = Duration.between(inicioViaje, finViaje);
	        long minutosTotales = duracion.toMinutes();
	        long segundosRestantes = duracion.getSeconds() % 60;

	        double tiempoTotalMin = duracion.toMillis() / 60000.0;  // Convertimos el tiempo total a minutos
	        double velocidadMediaKmMin = distanciaRecorridaKm / tiempoTotalMin;  // Calculamos la velocidad en km/min

	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");  // Formato de la hora de detención
	        System.out.println(" Coche detenido a las: " + finViaje.format(formatter));
	        System.out.println("Espacio recorrido total: " + String.format("%.2f", distanciaRecorridaKm) + " km.");
	        System.out.println("Tiempo total de viaje: " + minutosTotales + " minutos y " + segundosRestantes + " segundos.");
	        System.out.println("Velocidad media: " + String.format("%.2f", velocidadMediaKmMin) + " km/min.");
	    }

	}