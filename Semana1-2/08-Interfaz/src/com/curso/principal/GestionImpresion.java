package com.curso.principal;


import java.util.ArrayList;

import com.curso.interfaces.Imprime;
import com.curso.modelos.Factura;
import com.curso.modelos.Pagina;

public class GestionImpresion {

	public static void main(String[] args) {
		Factura f1 = new Factura(1, 22);
		Factura f2 = new Factura (2, 456);
		
		Pagina p1 = new Pagina(31, 15);
		Pagina p2 = new Pagina(157, 30);
		//TRABAJAR A PEDALINA, pensar porque seguro que hay una forma de automatizar
		//el proceso de invocar a los metodos
		
		f1.informeCorto();
		f1.informeLargo();
		f2.informeCorto();
		f2.informeLargo();
		
		
		p1.informeCorto();
		p1.informeLargo();
		p2.informeCorto();
		p2.informeLargo();
		
		
		//Las clases son TAD, tipos abstractis de datos y tambien las interfaces
		
		
		Imprime[] imprime = new Imprime[4]; 
		imprime[0] = new Factura(3,45);
		imprime[1] = new Factura(3,45);
		imprime[2] = new Pagina(34,89);
		imprime[3] = new Pagina(67,20);
		System.out.println("\t=======>SEGUNDA FORMA<=====");
		
		for (Imprime imp: imprime) {
			if(imp instanceof Factura) {
				System.out.println("\t\t\tSOY UNA FACTURA");
			}
			imp.informeCorto();
			imp.informeLargo();
		}
		//Vuestro trabajo consiste en usar un ArrayList para hacer la tercera forma 
		System.out.println("\t=======>TERCERA FORMA<=====");
		
		ArrayList<Imprime> documentos = new ArrayList<>();
		
		documentos.add(new Pagina(1,30));
		documentos.add(new Factura(12345, 24));
		documentos.add(new Pagina(16,56));
		documentos.add(new Factura(4567, 56));
		
		//Imprimir informes cortos
		 System.out.println("Informe corto para todos los documentos:");
	        for (Imprime documento : documentos) {
	            documento.informeCorto();
	        }

	        System.out.println("\nInforme largo para todos los documentos:");
	        // Imprimir todos los informes largos
	        for (Imprime documento : documentos) {
	            documento.informeLargo();
	        }
		
	}

}
