package com.curso;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("saludo")				// especifica la ruta de acceso relativa para una clase recurso o método
public class HolaRecurso1 {
	//http://localhost:8080/EjemploRest/rest/saludo
	@GET 						// especifican el tipo de petición HTTP de un recurso
	public String decirHola() {
		return "Hola Mundo";
	}
}
