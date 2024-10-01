package com.prueba.vehiculo;

import java.util.ArrayList;
import java.util.List;

public class Camion {
    private List<Double> tacometro;

    public Camion() {
        this.tacometro = new ArrayList<>();
    }

    public void agregarVelocidad(double velocidad) {
        this.tacometro.add(velocidad);
    }

    public List<Double> getTacometro() {
        return this.tacometro;
    }
}

