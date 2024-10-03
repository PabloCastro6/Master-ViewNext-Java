package com.curso.figurasGeometricas;

public class Circulo implements IFigura {
    private double radio;

    // Constructor
    public Circulo(double radio) {
        this.radio = radio;
    }

    // Implementación de los métodos de la interfaz
    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * Math.PI * radio;
    }
}



