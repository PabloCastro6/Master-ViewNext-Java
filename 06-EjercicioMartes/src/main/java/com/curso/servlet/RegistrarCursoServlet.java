package com.curso.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.curso.modelo.Alumno;
import com.curso.modelo.Curso;
import com.curso.utilidad.GestorDatos;

/**
 * Servlet implementation class RegistrarCursoServlet
 */
public class RegistrarCursoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 public static List<Curso> cursos = new ArrayList<>();
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombreAlumno = request.getParameter("nombre");
        String nombreCurso = request.getParameter("curso");

        // Verificar si el alumno existe
        Alumno alumno = null;
        for (Alumno a : RegistrarAlumnosServlet.alumnos) {
            if (a.getNombre().equals(nombreAlumno)) {
                alumno = a;
                break;
            }
        }

        if (alumno != null) {
        	  // Si el alumno no existe, se crea uno nuevo (opcional)
            alumno = new Alumno(nombreAlumno);
            RegistrarAlumnosServlet.alumnos.add(alumno);
        }
            
            
         // Comprobar si el curso ya existe
            Curso curso = null;
            for (Curso c : cursos) {
                if (c.getNombre().equals(nombreCurso)) {
                    curso = c;
                    break;
                }
            }

            // Si no existe el curso, crearlo
            if (curso == null) {
                curso = new Curso(nombreCurso);
                cursos.add(curso);
            }
            
         // Matricular al alumno en el curso
            curso.agregarAlumno(alumno);

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<title>Curso Matriculado</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Curso Matriculado</h2>");
            out.println("<p>Alumno: " + nombreAlumno + "</p>");
            out.println("<p>Curso matriculado: " + nombreCurso + "</p>");

            // Mostrar todos los cursos matriculados del alumno
            out.println("<h3>Cursos matriculados:</h3>");
            out.println("<ul>");
            for (Curso c : alumno.getCursosMatriculados()) {
                out.println("<li>" + c.getNombre() + "</li>");
            }
            out.println("</ul>");

            out.println("</body>");
            out.println("</html>");
            out.close();
        }
    }

