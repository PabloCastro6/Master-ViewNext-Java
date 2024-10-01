package com.prueba.vehiculos.model;

import java.time.LocalTime;

/**
 * class Vehiculo
 * 
 * @author Pablo Castro
 * @version 1.0, 30 sept 2024
 */

public abstract class Vehiculo {
    private String matricula;
    private int ruedas;

    public Vehiculo(String matricula, int ruedas) {
        this.matricula = matricula;
        this.ruedas = ruedas;
    }

    public String getMatricula() {
        return matricula;
    }

    public int getRuedas() {
        return ruedas;
    }
}