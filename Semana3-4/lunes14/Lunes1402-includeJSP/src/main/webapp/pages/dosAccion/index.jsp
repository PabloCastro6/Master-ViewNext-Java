<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ejemplo uso acción include</title>
</head>
<body>

 <jsp:include page="header.jsp"/>
    <h2>Contenido Principal</h2>
    <p>Este es el cuerpo de la página.</p>
 
 <jsp:include page="footer.jsp" />
</body>
</html>