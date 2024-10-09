<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Encabezados html creados con jsp</title>

</head>
<body>
<!-- Crear el archivo jsp, para que se cree esto:  
<h1>Bienvenidos a mi sitio web</h1>
<h2>Bienvenidos a mi sitio web</h2>
<h3>Bienvenidos a mi sitio web</h3>
<h4>Bienvenidos a mi sitio web</h4>
<h5>Bienvenidos a mi sitio web</h5>
<h6>Bienvenidos a mi sitio web</h6> -->

<% 
for (int i = 1; i < 6; i++) { %>
	
	 <h<%= i %>>Bienvenidos a mi sitio web </h<%=i %>>
<%} %>



</body>
</html>