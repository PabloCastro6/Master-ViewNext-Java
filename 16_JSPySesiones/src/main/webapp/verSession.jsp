<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
 <%@ page import="com.curso.model.Curso" %>   
 <%@ page import="com.curso.service.CursoService" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ver session</title>
</head>
<body>
<%
Curso c = (Curso)session.getAttribute("cursoelegido");
%>

<h2>El curso elegido por el usuario</h2>
Nombre: <b><%=c.getNombre() %></b><br>
Nivel: <b><%=c.getNivel() %></b>
</body>
</html>