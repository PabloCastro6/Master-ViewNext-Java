package com.prueba.vehiculos.model;

import java.time.LocalTime;

/**
 * class Vehiculo
 * 
 * @author Pablo Castro
 * @version 1.0, 30 sept 2024
 */

public abstract class Vehiculo {
	private String color;
	protected double velocidad; // Velocidad en km/h
	private double espacioRecorrido; // Espacio en km
	private LocalTime horaDeInicio; // Hora de inicio del viaje
	private LocalTime horaDeDetencion; // Hora de detención del viaje

	/**
	 * Clase abstracta que representa un vehículo genérico. Proporciona las
	 * propiedades y métodos comunes a todos los vehículos, como la gestión del
	 * tiempo de viaje, la distancia recorrida y la velocidad.
	 */
	public Vehiculo(String color) {
		this.color = color;
		this.velocidad = 0;
		this.espacioRecorrido = 0;
	}

	/**
	 * Obtiene el color actual del vehículo.
	 * 
	 * @return El color del vehículo.
	 */

	public String getColor() {
		return color;
	} 

	/**
	 * Cambia el color del vehículo.
	 * 
	 * @param color El nuevo color del vehículo.
	 */

	public void setColor(String color) {
		this.color = color;
	}

	public double getVelocidad() {
		return velocidad;
	}

	public double getEspacioRecorrido() {
		return espacioRecorrido;
	}

	// Método para iniciar el viaje (hora de inicio)
	public void iniciarViaje() {
		horaDeInicio = LocalTime.now().withSecond(0).withNano(0); // Guardar hora de inicio sin segundos ni decimales
	}

	// Método para detener el viaje (hora de detención)
	public void detenerViaje() {
		horaDeDetencion = LocalTime.now().withSecond(0).withNano(0); // Guardar hora de detención sin segundos ni
																		// decimales
	}

	public LocalTime getHoraDeInicio() {
		return horaDeInicio;
	}

	public LocalTime getHoraDeDetencion() {
		return horaDeDetencion;
	}

	// Incrementar espacio recorrido en km
	protected void avanzar(double km) {
		this.espacioRecorrido += km;
	}

	// Calcular la velocidad media en km/h
	protected void calcularVelocidad(double tiempoHoras) {
		if (tiempoHoras > 0) {
			this.velocidad = espacioRecorrido / tiempoHoras;
		}
	}
}