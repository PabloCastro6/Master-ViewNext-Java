package com.curso.director;

import java.util.ArrayList;

import com.curso.modelo.DirectorDeOrquesta;
import com.curso.modelo.Flauta;
import com.curso.modelo.Guitarra;
import com.curso.modelo.GuitarraElectrica;
import com.curso.modelo.Instrumento;
import com.curso.modelo.Tambor;

public class Orquesta {
	public static void main(String[] args) {
		ArrayList<Instrumento> instrumentos = new ArrayList<>();
		
        instrumentos.add(new Flauta("Flauta dulce", "Viento", "Yamaha"));
        instrumentos.add(new Guitarra("Guitarra clásica", "Cuerda", 6));
        instrumentos.add(new GuitarraElectrica("GuitarraElectrica", "Cuerda", 6, 100));
        instrumentos.add(new Tambor("Tambor grande", "Percusión", "Grande"));

        DirectorDeOrquesta director = new DirectorDeOrquesta();
        
        

        /* Instrumento [] intrumentos = {};
         * for(Instrumento instr:instrumentos)
 {
 if(inst instanceof Tambor) {
 "aporrear()"
 }else inst.tocar();
 }
 }         * 
         * 
         */
//        // Crear un array de instrumentos
//        Instrumento[] instrumentos = {flauta, guitarra, guitarraElectrica, tambor};
//
//        // Iniciar el concierto con el director
         director.iniciarConcierto(instrumentos);

        
//        flauta.tocar();
//        guitarra.tocar();
//        guitarraElectrica.tocar();
//        tambor.aporrear();  // El tambor se aporrea
         
         
        
    }
}
