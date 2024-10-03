package com.curso.modelos;

import com.curso.interfaces.Imprime;

public class Factura implements Imprime {
	/**
	 * Clase que identifica el cliente de cada factura
	 * 
	 * 
	 * @author Pablo Castro
	 * @version 1.0 2024/09/26
	 */
	
	
	private int nFactura;
	private int codigoCliente;
	

	public Factura(int i, int j) {
		nFactura = i;
		codigoCliente = j;
	}
	

	@Override
	public void informeLargo() {
		System.out.println("Al cliente con codigo " + codigoCliente + " le corresponde la factura " + nFactura) ;
		
	}

	@Override
	public void informeCorto() {
		System.out.println("El número de la factura es " + nFactura);
		
	}

}
