package com.prueba.vehiculos.model;

import java.time.LocalTime;

/**
 * class Vehiculo
 * @author Pablo Castro
 * @version 1.0, 30 sept 2024 
 */
 
public abstract class Vehiculo {
	private String color;
	private int velocidad;
	private int espacioRecorrido;
	private long tiempoInicial;
	private long tiempoFinal;
	private long tiempoDeViaje;
	private LocalTime horaDeInicio;
	private long tiempoDeDetencion;
	
	/**
	 * Clase abstracta que representa un vehículo genérico. 
	 * Proporciona las propiedades y métodos comunes a todos los vehículos, 
	 * como la gestión del tiempo de viaje, la distancia recorrida y la velocidad.
	 */
	public Vehiculo(String color) {
		this.color = color;
		this.velocidad = 0;
		this.espacioRecorrido = 0;
		this.tiempoDeViaje = 0;
		this.tiempoDeDetencion = 0; // Inicializamos el tiempo de detención
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

	public void setVelocidad(double velocidad) {
		this.velocidad = (int)Math.round(velocidad); //Redondeamos a entero
	}

	public double getEspacioRecorrido() {
		return espacioRecorrido;
	}
	

	protected void incrementarEspacioRecorrido(double metros) {
		this.espacioRecorrido += (int) Math.round(metros); //Redondeamos a entero
		
	}
	
	public long getTiempoDeViaje() {
		return tiempoDeViaje;
	}
	

    public LocalTime getHoraDeInicio() {
        return horaDeInicio;
    }
	
	protected void iniciarViaje() {
		this.tiempoInicial = System.currentTimeMillis(); //Almacenar tiempo de inicio	
		this.horaDeInicio = LocalTime.now();
	}
	

	 protected void finalizarViaje() {
	        this.tiempoFinal = System.currentTimeMillis();  // Registramos el tiempo de finalización
	        this.tiempoDeViaje += (tiempoFinal - tiempoInicial);  // Calculamos el tiempo total de viaje

	        // Calcular la velocidad media solo si el tiempo es mayor a 0
	        if (tiempoDeViaje > 0) {
	            // Convertimos el tiempo a segundos (dividiendo entre 1000.0) y calculamos la velocidad en enteros
	            double tiempoSegundos = tiempoDeViaje / 1000.0;
	            this.velocidad = (int) Math.round(espacioRecorrido / tiempoSegundos);
	        }
	    }

	    protected void registrarTiempoDetencion() {
	        this.tiempoDeDetencion = System.currentTimeMillis(); // Guardamos el tiempo actual al detenerse
	    }

	    public long getTiempoDeDetencion() {
	        return tiempoDeDetencion; // Retornamos el tiempo de detención
	    }
	}
	

