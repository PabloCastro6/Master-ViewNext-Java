package com.curso.modelo;

import java.util.ArrayList;

public class DirectorDeOrquesta {
	public void iniciarConcierto(ArrayList<Instrumento> instrumentos) {
        System.out.println("El director está iniciando el concierto...");

        //Antes de tocar afinar instrumentos
        afinarTodos(instrumentos);

        // Hacer que los instrumentos toquen
        for (Instrumento instrumento : instrumentos) {
         if(instrumento instanceof Tambor) {
        	 ((Tambor) instrumento).tocar(); //Si es tambor, se aporrea
         }else {
        	 instrumento.tocar();
         }
        }
    }

	private void afinarTodos(ArrayList<Instrumento> instrumentos) {
        System.out.println("El director está indicando que afinen todos los instrumentos...");
        for (Instrumento instrumento : instrumentos) {
            instrumento.afinar();
        }
    }


}
