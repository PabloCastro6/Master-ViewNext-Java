package com.agenda.principal;

import com.agenda.consultas.ConsultaPersonas;
import com.agenda.model.Persona;

public class Principal {
    public static void main(String[] args) {
        ConsultaPersonas consulta = new ConsultaPersonas();

        // Mostrar todas las personas
        System.out.println("Todas las personas:");
        consulta.buscarTodas().forEach(System.out::println);

        // Buscar persona por ID
        System.out.println("Persona con ID 1:");
        System.out.println(consulta.buscarPorId(1));

        //  Buscar personas por primer apellido
        System.out.println("Personas con apellido 'Garcia':");
        consulta.buscarPorApellido1("Garcia").forEach(System.out::println);

        //  Buscar personas por primer y segundo apellido
        System.out.println("Personas con apellidos 'Garcia' y 'Lopez':");
        consulta.buscarPorApellido1yApellido2("Garcia", "Lopez").forEach(System.out::println);
    }
}
