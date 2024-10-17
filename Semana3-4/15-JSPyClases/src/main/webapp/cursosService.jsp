<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.curso.service.CursoService" %>
<%@ page import="com.curso.model.Curso" %>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cursos y nivel</title>
</head>
<body>
<%
	CursoService cs= new CursoService();
	List<Curso> listaCursos= cs.buscarTodos();
	
	for(Curso curso:listaCursos){%>
		<p>Nombre del curso: <%=curso.getNombre() %> - Nivel del curso: <%=curso.getNivel() %> <p>
	<%}%>
	

</body>
</html>