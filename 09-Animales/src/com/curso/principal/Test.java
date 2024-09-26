package com.curso.principal;

import com.curso.animales.Araña;
import com.curso.mascotas.Gato;
import com.curso.mascotas.Pez;

public class Test {

	public static void main(String[] args) {
		
		Araña araña = new Araña();
		araña.andar();
		araña.comer();
		
		Gato gato = new Gato("Machu");
		gato.andar();
		gato.comer();
		gato.jugar();
		
		Pez pez = new Pez("Nemo");
		pez.andar();
		pez.comer();
		pez.jugar();

	}

}
