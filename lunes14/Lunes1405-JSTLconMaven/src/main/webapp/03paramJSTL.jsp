<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Eco datos formulario</title>
</head>
<body>
<!-- El objeto param me permite acceder a los parámetros que provienen de un formulario -->
<c:out value="${param.nombre}"></c:out>
</body>
</html>