package com.curso.orquesta;

public class DirectorDeOrquesta {
	public void iniciarConcierto(Instrumento[] instrumentos) {
        System.out.println("El director está iniciando el concierto...");

        //Antes de tocar afinar instrumentos
        afinarTodos(instrumentos);

        // Hacer que los instrumentos toquen
        for (Instrumento instrumento : instrumentos) {
            if (instrumento instanceof Tambor) {
                ((Tambor) instrumento).aporrear();
            } else {
                instrumento.tocar();  
            }
        }
    }

    private void afinarTodos(Instrumento[] instrumentos) {
        System.out.println("El director está indicando que afinen todos los instrumentos...");
        for (Instrumento instrumento : instrumentos) {
            instrumento.afinar();
        }
    }

}
