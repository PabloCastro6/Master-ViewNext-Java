<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hola 2</title>
</head>
<body>
<%
//en 01hola.jsp hemos usado out.println(saludo)
//Ahora vamos a usar una expresion JSP
String texto = "Otra vez hola";
%>

<h2>Un texto cualquiera del scriplet</h2>
<!-- Esto es una expresion JSP -->
<%=texto %>
</body>
</html>