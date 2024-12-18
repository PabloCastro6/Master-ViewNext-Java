package com.cursojava.cafeteria;

public class Cafetera {
     int capacidadMaxima;
     int cantidadActual;

    // Constructor predeterminado (capacidad máxima = 1000 c.c., cafetera vacía)
    public Cafetera() {
        this.capacidadMaxima = 1000;
        this.cantidadActual = 0;
    }

    // Constructor que inicializa la cafetera con la capacidad máxima, llena de café
    public Cafetera(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
        this.cantidadActual = capacidadMaxima;
    }

    // Constructor con capacidad máxima y cantidad actual
    public Cafetera(int capacidadMaxima, int cantidadActual) {
        this.capacidadMaxima = capacidadMaxima;
        if (cantidadActual > capacidadMaxima) {
            this.cantidadActual = capacidadMaxima;
        } else {
            this.cantidadActual = cantidadActual;
        }
    }

    
    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public int getCantidadActual() {
        return cantidadActual;
    }

   
    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public void setCantidadActual(int cantidadActual) {
        if (cantidadActual > capacidadMaxima) {
            this.cantidadActual = capacidadMaxima;
        } else {
            this.cantidadActual = cantidadActual;
        }
    }

    
    public void llenarCafetera() {
        this.cantidadActual = capacidadMaxima;
    }

    // Método servirTaza(int): sirve la cantidad solicitada o lo que quede de café
    public void servirTaza(int cantidadAServir) {
        if (cantidadActual >= cantidadAServir) {
            cantidadActual -= cantidadAServir;
            System.out.println("Se ha servido una taza de " + cantidadAServir + " c.c.");
        } else {
            System.out.println("No hay suficiente café. Se ha servido lo que quedaba: " + cantidadActual + " c.c.");
            cantidadActual = 0;
        }
    }

    // Método vaciarCafetera(): vacía la cafetera
    public void vaciarCafetera() {
        this.cantidadActual = 0;
    }

    // Método agregarCafe(int): añadela cantidad indicada a la cafetera
    public void agregarCafe(int cantidadAAgregar) {
        if (cantidadActual + cantidadAAgregar > capacidadMaxima) {
            System.out.println("La cafetera se llenó al máximo con " + (capacidadMaxima - cantidadActual) + " c.c.");
            cantidadActual = capacidadMaxima;
        } else {
            cantidadActual += cantidadAAgregar;
            System.out.println("Se han agregado " + cantidadAAgregar + " c.c. de café.");
        }
    }
}

