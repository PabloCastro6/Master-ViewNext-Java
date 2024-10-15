package com.curso.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.curso.modelo.Alumno;
import com.curso.modelo.Curso;

public class RegistrarCursoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public static List<Curso> cursos = new ArrayList<>();

    protected void doPOST(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombreAlumno = request.getParameter("nombreAlumno");
        String nombreCurso = request.getParameter("curso");

        // Buscar al alumno en la lista
        Alumno alumno = null;
        for (Alumno a : RegistrarAlumnosServlet.alumnos) {
            if (a.getNombre().equalsIgnoreCase(nombreAlumno)) {
                alumno = a;
                break;
            }
        }

        if (alumno == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "El alumno no está registrado."); //Constante que dice el estado HTTP400, VALIDA O NO(HttpServletResponse.SC_BAD_REQUEST)
            return;
        }

        // Matricular al alumno en el curso
        Curso curso = new Curso(nombreCurso);
        alumno.matricularEnCurso(curso);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<title>Matriculación de curso</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>" + alumno.getNombre() + ", estás matriculado en los cursos siguientes:</h2>");

        // Mostrar los cursos en los que el alumno está matriculado
        List<Curso> cursosMatriculados = alumno.getCursosMatriculados();
        if (cursosMatriculados.isEmpty()) {
            out.println("<p>No estás matriculado en ningún curso.</p>");
        } else {
            out.println("<ul>");
            for (Curso c : cursosMatriculados) {
                out.println("<li>" + c.getNombre() + "</li>");
            }
            out.println("</ul>");
        }

        // Enlace para matricularse en otro curso
        out.println("<p><a href='formularioCurso.html'>Matricularse en otro curso</a></p>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
