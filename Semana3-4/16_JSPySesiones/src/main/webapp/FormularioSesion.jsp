<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
 <%@ page import="java.util.List" %>   
 <%@ page import="com.curso.model.Curso" %>   
 <%@ page import="com.curso.service.CursoService" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulario</title>
</head>
<body>
<h1>Elige un curso del desplegable</h1>

<%
CursoService cs = new CursoService();
List<Curso> listaCursos = cs.buscarTodos();
%>
<form action="sesionImplicita.jsp" method="post">
	<select name="nombrecurso">
	<% for(Curso c:listaCursos) {	%>
	<option value="<%=c.getNombre()%>"><%=c.getNombre()%></option>
	<%} %>
	</select>
	<input type="submit" value="Enviar">
</form>





</body>
</html>