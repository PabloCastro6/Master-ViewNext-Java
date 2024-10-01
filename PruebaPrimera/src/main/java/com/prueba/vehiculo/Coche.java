package com.prueba.vehiculo;

import java.time.Duration;
import java.time.LocalDateTime;
import com.prueba.vehiculo.interfaces.Conducible;
import com.prueba.vehiculos.model.Vehiculo;

/**
 * class Coche
 * Clase que representa un coche, heredando de la clase Vehiculo
 * @author Pablo Castro
 * @version 1.0, 30 sept 2024 
 */

/**
 * Implementando la interfaz Conducible. Define características específicas
 * de un coche, como la matrícula y el número de ruedas.
 */

public class Coche extends Vehiculo implements Conducible {

    private final String matricula;
    private static final int NUMERO_RUEDAS = 4;
    private LocalDateTime inicioViaje;
    private LocalDateTime ultimoAvance; // Para registrar el último tiempo en que avanzó
    private LocalDateTime finViaje;
    private boolean enViaje = false;

    /**
     * Constructor que inicializa un coche con un color y una matrícula específicos.
     * 
     * @param color     El color del coche.
     * @param matricula La matrícula del coche (inmutable).
     */
    public Coche(String color, String matricula) {
        super(color);
        this.matricula = matricula;
    }

    /**
     * Método que inicia el viaje del coche, registrando el tiempo inicial.
     */
    @Override
    public void arrancar() {
        if (!enViaje) {
            inicioViaje = LocalDateTime.now().withSecond(0).withNano(0); // Hora de inicio sin segundos
            ultimoAvance = inicioViaje; // Registrar el tiempo del primer avance
            enViaje = true;
            System.out.println("Tiempo inicial del viaje: " + inicioViaje.toLocalTime());
        } else {
            System.out.println("El coche ya está en marcha.");
        }
    }

    /**
     * Método para avanzar el coche. Suma los kilómetros avanzados a la distancia total y actualiza la hora.
     */
    @Override
    public void avanzar(double kmAvanzados, int velocidad) {
        if (!enViaje) {
            System.out.println("El coche no está en marcha. Debes arrancarlo antes de avanzar.");
            return;
        }

        // Actualizar la distancia recorrida y la velocidad
        super.avanzar(kmAvanzados);
        setVelocidad(velocidad);

        // Calcular el tiempo transcurrido desde el último avance
        LocalDateTime ahora = LocalDateTime.now().withSecond(0).withNano(0);
        Duration duracion = Duration.between(ultimoAvance, ahora);
        ultimoAvance = ahora; // Actualizar el último tiempo de avance

        System.out.println("Avanzo " + kmAvanzados + " km. Velocidad: " + getVelocidad() + " km/h.");
      //  System.out.println("Hora actual: " + ahora.toLocalTime());
    }

    private void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    /**
     * Método que detiene el coche, registrando el tiempo final del viaje y
     * calculando la velocidad media.
     */
    @Override
    public void parar() {
        if (enViaje) {
            finViaje = LocalDateTime.now().withSecond(0).withNano(0);
            Duration duracion = Duration.between(inicioViaje, finViaje);
            double tiempoHoras = duracion.toMinutes() / 60.0;

            // Calcular la velocidad media con la distancia total recorrida
            calcularVelocidad(tiempoHoras);

            System.out.println("Coche detenido a las: " + finViaje.toLocalTime());
            System.out.println("Distancia total: " + getEspacioRecorrido() + " km.");
            System.out.println("Velocidad media: " + String.format("%.2f", getVelocidad()) + " km/h.");
            
            enViaje = false;
        } else {
            System.out.println("El coche ya está detenido.");
        }
    }
}
