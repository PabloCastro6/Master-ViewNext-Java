package com.curso.thisdelegar;

public class Persona {
        private int edad;
        private String nombre;
        private double altura;
        private double peso;
        
        public Persona(int edad) {
                this.edad = edad;
        }
        
        public Persona(int edad,String nombre) {
                this(edad);
                this.nombre = nombre;
        }
        public Persona(int edad,String nombre, double altura) {
                this(edad, nombre);
                this.altura = altura;
        }
        public Persona(int edad,String nombre, double altura, double peso) {
                this(edad, nombre, altura);
                this.peso = peso;
        }

        @Override
        public String toString() {
                return "Persona [edad=" + edad + ", nombre=" + nombre + ", altura=" + altura + ", peso=" + peso + "]";
        }        
        
        
}

