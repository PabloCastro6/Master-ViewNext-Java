package com.curso;

public class Estadistica {
	// Calcula la media de una serie de valores que son del mismo tipo
	// 1+2 / 2, 1+2+3 / 3
	
	public double media (int x1, int x2) {
		double resultado = x1 + x2 / 2;
		return resultado;
	}
	
	//Tres elementos
	public double media (int x1, int x2, int x3) {
		double resultado = x1 + x2 + x3 / 3;
		return resultado;
	}
	
	//Cuatro elementos 
	public double media (int x1, int x2, int x3, int x4) {
		double resultado = x1 + x2 + x3 + x4 / 4;
		return resultado;
	}
	
	//Haciendo uso de VARARGS(Numero de elementos variable) puedo poner:
	
	public double otraMedia(int...numero) {
		int suma = 0;
		double resultado = 0;
		
		 for(int x: numero) {
			 suma +=x;
		 }
		 resultado = suma/numero.length;
		 return resultado;
	}
	

}
