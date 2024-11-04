package com.curso.model;

import java.util.Objects;


/**
 * Representa un curso con un código, nombre, duración y precio.
 */
public class Curso {
    private int codCurso;
    private String nombre;
    private int duracion; // en horas
    private double precio;

    /**
     * Constructor por defecto.
     */
    public Curso() {
        super();
    }

    /**
     * Constructor con parámetros.
     *
     * @param codCurso Código del curso.
     * @param nombre   Nombre del curso.
     * @param duracion Duración en horas del curso.
     * @param precio   Precio del curso.
     */
    public Curso(int codCurso, String nombre, int duracion, double precio) {
        this.codCurso = codCurso;
        this.nombre = nombre;
        this.duracion = duracion;
        this.precio = precio;
    }

    
    // Getters y Setters
    /**
     * Obtiene el código del curso.
     * @return Código del curso.
     */
    public int getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(int codCurso) {
        this.codCurso = codCurso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    // Métodos equals y hashCode para comparar objetos Curso por codCurso
    @Override
    public int hashCode() {
        return Objects.hash(codCurso);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Curso other = (Curso) obj;
        return codCurso == other.codCurso;
    }

    @Override
    public String toString() {
        return "Curso [codCurso=" + codCurso + ", nombre=" + nombre + ", duracion=" + duracion + " horas, precio=" + precio + "]";
    }
}
