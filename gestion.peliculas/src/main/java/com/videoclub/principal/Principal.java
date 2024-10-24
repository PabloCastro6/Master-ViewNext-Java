package com.videoclub.principal;

import com.videoclub.consultas.ConsultaPeliculas;
import com.videoclub.model.Pelicula;

import java.sql.SQLException;

public class Principal {
    public static void main(String[] args) {
    	ConsultaPeliculas consulta = new ConsultaPeliculas();

        // Mostrar todas las películas
        System.out.println("=========>>> TODAS LAS PELÍCULAS ==============");
        for (Pelicula pelicula : consulta.buscarTodas()) {
            System.out.println(pelicula);
        }

        // Mostrar películas cuyo director es "Cosme"
        System.out.println("========>>>>> POR DIRECTOR (Cosme) ============");
        for (Pelicula pelicula : consulta.buscarPorDirector("Cosme")) {
            System.out.println(pelicula);
        }

        // Mostrar películas cuyo director empieza con "M"
        System.out.println("========>>>>> DIRECTOR EMPIEZA CON M ===========");
        for (Pelicula pelicula : consulta.buscarPorDirectorEmpiezaCon("M")) {
            System.out.println(pelicula);
        }

        // Mostrar películas cuya directora es Ana o Eva
        System.out.println("========>>>>> DIRECTORAS (Ana o Eva) ===========");
        for (Pelicula pelicula : consulta.buscarPorDirectoras()) {
            System.out.println(pelicula);
        }

        // Mostrar directores
        System.out.println("========>>>>> DIRECTORES =======================");
        for (String director : consulta.mostrarDirectores()) {
            System.out.println(director);
        }

        // Mostrar películas con precio entre 20 y 55
        System.out.println("========>>>>> PRECIO ENTRE 20 Y 55 =============");
        for (Pelicula pelicula : consulta.buscarPorPrecio(20, 55)) {
            System.out.println(pelicula);
        }

//        // Contar películas por precio
//        System.out.println("========>>>>> PELÍCULAS POR PRECIO =============");
//        for (String resultado : consulta.contarPeliculasPorPrecio()) {
//            System.out.println(resultado);
//        }
    }
}