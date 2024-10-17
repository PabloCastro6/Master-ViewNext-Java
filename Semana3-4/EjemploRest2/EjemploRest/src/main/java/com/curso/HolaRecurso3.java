package com.curso;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("saludo3")	 // especifica la ruta de acceso relativa para una clase recurso o método
public class HolaRecurso3 {
	//http://localhost:8080/EjemploRest/rest/saludo3
	
	@GET  		// especifican el tipo de petición HTTP de un recurso		

	@Produces(MediaType.APPLICATION_JSON)//especifica el tipo de la respuesta
	public String decirHolaJSON() {
		return "{\"nombre\":\"Pepito\",\"departamento\":\"Ventas\",\"edad\":35}";
	}
}
