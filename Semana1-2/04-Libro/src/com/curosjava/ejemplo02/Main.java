package com.curosjava.ejemplo02;

public class Main {
    public static void main(String[] args) {
        // Crear dos objetos Libro
        Libro libro1 = new Libro(123456, "El Principito", "Antoine de Saint-Exupéry", 396);
        Libro libro2 = new Libro(789101, "Cien años de soledad", "Gabriel García Márquez", 417);

        // Mostrar la información de los libros
        System.out.println(libro1);
        System.out.println(libro2);

        // Comparar cuál tiene más páginas utilizando el método compararPaginas
        System.out.println(libro1.compararPaginas(libro2));
    }
}
