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

public class RegistrarAlumnosServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public static List<Alumno> alumnos = new ArrayList<>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombreAlumno = request.getParameter("nombre");

        // Registrar alumno si no existe
        boolean existe = false;
        for (Alumno alumno : alumnos) {
            if (alumno.getNombre().equalsIgnoreCase(nombreAlumno)) {
                existe = true;
                break;
            }
        }

        if (!existe) {
            alumnos.add(new Alumno(nombreAlumno)); // Agregar nuevo alumno
        }

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
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
