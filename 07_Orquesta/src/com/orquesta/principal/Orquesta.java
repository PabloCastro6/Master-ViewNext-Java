package com.orquesta.principal;

import com.curso.orquesta.DirectorDeOrquesta;
import com.curso.orquesta.Flauta;
import com.curso.orquesta.Guitarra;
import com.curso.orquesta.GuitarraElectrica;
import com.curso.orquesta.Instrumento;
import com.curso.orquesta.Tambor;

public class Orquesta {
	public static void main(String[] args) {
		
        Flauta flauta = new Flauta("Flauta dulce", "Viento", "Yamaha");
        Guitarra guitarra = new Guitarra("Guitarra clásica", "Cuerda", 6);
        GuitarraElectrica guitarraElectrica = new GuitarraElectrica("GuitarraElectrica", "Cuerda", 6, 100);
        Tambor tambor = new Tambor("Tambor grande", "Percusión", "Grande");

        DirectorDeOrquesta director = new DirectorDeOrquesta();

        // Crear un array de instrumentos
        Instrumento[] instrumentos = {flauta, guitarra, guitarraElectrica, tambor};

        // Iniciar el concierto con el director
        director.iniciarConcierto(instrumentos);

        
        flauta.tocar();
        guitarra.tocar();
        guitarraElectrica.tocar();
        tambor.aporrear();  // El tambor se aporrea
        
    }
}
