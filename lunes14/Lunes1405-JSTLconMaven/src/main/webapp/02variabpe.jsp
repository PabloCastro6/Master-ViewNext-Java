<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Trabajando con variables</title>
</head>
<body>
<c:set var="nombre" value="pepito"></c:set>
El valor guardado es <c:out value="${nombre}"></c:out>

<c:remove var="nombre"></c:remove>
El valor guardado es <c:out value="${nombre}"></c:out>
</body>
</html>