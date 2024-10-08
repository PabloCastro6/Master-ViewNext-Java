package com.curso.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.curso.modelo.Curso;
import com.curso.utilidad.GestorDatos;

/**
 * Servlet implementation class RegistrarCursoServlet
 */
public class RegistrarCursoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombreCurso = request.getParameter("curso");

        // Registrar el curso en el sistema (disponible para todos los alumnos)
        GestorDatos.registrarCurso(nombreCurso);

        // Generar la respuesta
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<title>Curso Registrado</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>Curso Registrado</h2>");
        out.println("<p>Curso registrado: " + nombreCurso + "</p>");
        out.println("<p><a href='formularioCurso.html'>Registrar otro curso</a></p>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
	
