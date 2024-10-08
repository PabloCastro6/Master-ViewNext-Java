package com.curso.java;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class CrearCookie
 */
public class CrearCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Cookie: Forma en la que nosotros podemos guardar una informacion, se guardan en el navegador en la memoria del equipo. 
		Cookie c1 = new Cookie("nombre", "Pepito");
		c1.setMaxAge(60); //establezco tiempo duracion de la cookie. Es opcional
		response.addCookie(c1); 
		
		
		Cookie c2 = new Cookie("edad ", "25");
		c2.setMaxAge(90);
		response.addCookie(c2);
		
	}

	

}
