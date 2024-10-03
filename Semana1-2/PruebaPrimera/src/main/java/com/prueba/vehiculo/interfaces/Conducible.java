package com.prueba.vehiculo.interfaces;

/**
 * Interfaz que define los métodos que deben implementar las clases que
 * representen vehículos conducibles. Permite estandarizar la manera en que un
 * vehículo puede arrancar, avanzar, retroceder y detenerse.
 */
public interface Conducible {
	    void avanzar(double distanciaKm, double velocidad);
	    void parar();
}