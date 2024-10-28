package com.videoclub.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "peliculas")
@NamedQueries({
    @NamedQuery(name = "Pelicula.buscarTodas", query = "SELECT p FROM Pelicula p"),
    @NamedQuery(name = "Pelicula.buscarPorDirector", query = "SELECT p FROM Pelicula p WHERE p.director = :director"),
    @NamedQuery(name = "Pelicula.buscarPorDirectorEmpiezaCon", query = "SELECT p FROM Pelicula p WHERE p.director LIKE :patron"),
    @NamedQuery(name = "Pelicula.buscarPorDirectoras", query = "SELECT p FROM Pelicula p WHERE p.director LIKE '%Ana%' OR p.director LIKE '%Eva%'"),
    @NamedQuery(name = "Pelicula.mostrarDirectores", query = "SELECT DISTINCT p.director FROM Pelicula p"),
    @NamedQuery(name = "Pelicula.buscarPorPrecio", query = "SELECT p FROM Pelicula p WHERE p.precio_alquiler > :min AND p.precio_alquiler < :max")
})
public class Pelicula {
    @Id
    private int codigo;
    private String titulo;
    private String director;
    private double precio_alquiler;

    // Constructores, getters, setters, toString, equals, hashCode
    public Pelicula() {}

    public Pelicula(int codigo, String titulo, String director, double precio_alquiler) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.director = director;
        this.precio_alquiler = precio_alquiler;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public double getPrecio_alquiler() {
        return precio_alquiler;
    }

    public void setPrecio_alquiler(double precio_alquiler) {
        this.precio_alquiler = precio_alquiler;
    }

    @Override
    public String toString() {
        return "Pelicula [codigo=" + codigo + ", titulo=" + titulo + ", director=" + director + ", precio_alquiler=" + precio_alquiler + "]";
    }
}