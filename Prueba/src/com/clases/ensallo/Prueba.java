package com.clases.ensallo;

public class Prueba {
	


String unaCadena = "Hola";
System.out.println("Una Cadena la primera vez = " + unaCadena);
 unaCadena += "mundo";   //Pero no eran inmutables  los String
System.out.println("Una Cadena la segunda vez = "+unaCadena);

String otraCadena = "Hola";
System.out.println("Una Cadena la primera vez = "+otraCadena);
//otraCadena.concat(" mundo");
String resultado=otraCadena.concat(" mundo");
System.out.println("Después de usar el método concat() = "+otraCadena);
System.out.println("HE tenido que crear resultado para almacenar el valor de la concatenación " + resultado);
}
}