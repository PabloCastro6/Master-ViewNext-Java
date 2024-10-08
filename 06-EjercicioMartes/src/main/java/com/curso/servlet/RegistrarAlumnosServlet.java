package com.curso.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.curso.modelo.Alumno;
import com.curso.modelo.Curso;
import com.curso.utilidad.GestorDatos;

/**
 * Servlet implementation class RegistrarAlumnosServlet
 */
public class RegistrarAlumnosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String nombreAlumno = request.getParameter("nombre");
	        GestorDatos.registrarAlumno(nombreAlumno);  // Registra al alumno si no existe

	        // Generar la respuesta para mostrar los datos del alumno y los cursos disponibles
	        Alumno alumno = GestorDatos.obtenerAlumno(nombreAlumno);

	        response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
	        out.println("<!DOCTYPE html>");
	        out.println("<html>");
	        out.println("<head>");
	        out.println("<meta charset=\"UTF-8\">");
	        out.println("<title>Alumno Registrado</title>");
	        out.println("</head>");
	        out.println("<body>");
	        
	        
	        out.println("<h2>Persona registrada en el sistema</h2>");
	        out.println("<p>Nombre de la persona registrada: " + nombreAlumno + "</p>");
	        out.println("<p>Se puede matricular en nuestros cursos accediendo al <a href='formularioCurso.html'>Formulario del curso</a></p>");

	        // Si hay cursos matriculados los mostramos
	        if (alumno != null && !alumno.getCursoMatriculados().isEmpty()) {
	            out.println("<h3>Cursos en los que estás matriculado:</h3>");
	            out.println("<ul>");
	            alumno.getCursoMatriculados().forEach(curso -> out.println("<li>" + curso.getNombre() + "</li>"));
	            out.println("</ul>");
	        }

	        out.println("</body>");
	        out.println("</html>");
	        out.close();
	    }
	}
	


