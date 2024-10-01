package com.prueba.vehiculo;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import com.prueba.vehiculo.interfaces.Conducible;
import com.prueba.vehiculos.model.Vehiculo;

public class Coche extends Vehiculo implements Conducible {
    private String color;
    private int metrosRecorridos;
    private long tiempoInicioViaje;
    private double velocidad;

    public Coche(String matricula, String color) {
        super(matricula, 4); // 4 ruedas por defecto
        this.color = color;
    }

   
    public void avanzar(double distanciaKm, double velocidad) {
        this.velocidad = velocidad;
        metrosRecorridos += (int) (distanciaKm * 1000);
    }

    
    public void parar() {
        double distanciaRecorridaKm = metrosRecorridos / 1000.0;
        double tiempoTranscurridoHoras = distanciaRecorridaKm / velocidad;
        long tiempoTranscurridoMs = (long) (tiempoTranscurridoHoras * 3600000);
        long tiempoParada = tiempoInicioViaje + tiempoTranscurridoMs;
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm"); //Formato de la hora
        System.out.println("Hora de parada del viaje: " + sdf.format(new java.util.Date(tiempoParada))); //Formatear fecha y hora 
        if (tiempoTranscurridoHoras < 1) {
            long minutosTranscurridos = (long) (tiempoTranscurridoMs / 60000);
            System.out.println("Tiempo transcurrido: " + minutosTranscurridos + " minutos");
        } else {
            DecimalFormat df = new DecimalFormat("#");
            System.out.println("Tiempo transcurrido: " + df.format(tiempoTranscurridoHoras) + " horas");
        }
        System.out.println("Velocidad: " + velocidad + " km/h");
        System.out.println("Distancia recorrida: " + distanciaRecorridaKm + " km");
    }


    public int getMetrosRecorridos() {
        return metrosRecorridos;
    }

    public void arrancar() {
        tiempoInicioViaje = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        System.out.println("Hora de inicio del viaje: " + sdf.format(new java.util.Date(tiempoInicioViaje)));
    }

    public void pintar(String color) {
        this.color = color;
    }

    public long getTiempoInicioViaje() {
        return tiempoInicioViaje;
    }




	public double getVelocidad() {
		// TODO Auto-generated method stub
		return 0;
	}
    
    

	
	
}

