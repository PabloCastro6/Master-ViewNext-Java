package com.cursoJava.cuenta;

public class Main {
	    public static void main(String[] args) {
	       
	        Cuenta cuenta1 = new Cuenta("Juan Pérez", 50);
	        System.out.println(cuenta1);  

	        
	        cuenta1.ingresar(100);
	        System.out.println(cuenta1);  

	        
	        cuenta1.retirar(150);
	        System.out.println(cuenta1);  
	        
	        
	        Cuenta cuenta2 = new Cuenta("Ana López", 200);
	        System.out.println(cuenta2);  

	        
	        cuenta2.ingresar(50);
	        System.out.println(cuenta2); 

	                                                           
	        cuenta2.retirar(100);
	        System.out.println(cuenta2);  
	    }
	}
