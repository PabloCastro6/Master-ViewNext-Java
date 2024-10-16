package com.curso;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("saludo2")		// especifica la ruta de acceso relativa para una clase recurso o método
public class HolaRecurso2 {	
	//http://localhost:8080/EjemploRest/rest/saludo2
	@GET  		// especifican el tipo de petición HTTP de un recurso
	@Produces(MediaType.TEXT_HTML)		//especifica el tipo de la respuesta
	public String decirHolaHtml() {
		return "<html><body><h1>Hola mundo</h1></body></html>";
	}
	
}
