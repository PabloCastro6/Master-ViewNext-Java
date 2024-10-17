<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>     
 <%@ page import="com.curso.model.Curso" %>   
 <%@ page import="com.curso.service.CursoService" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Almacenar en session el curso seleccionado</title>
</head>
<body>
<%
CursoService cs = new CursoService();
Curso c = cs.buscarUno(request.getParameter("nombrecurso"));
session.setAttribute("cursoelegido", c);
%>

<p>Se ha almacenado un objeto en session.</p>

<a href="verSession.jsp">Mostrar el curso elegido</a>

</body>
</html>