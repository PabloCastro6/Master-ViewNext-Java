<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.almacen.modelo.Producto"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Borrar Producto</title>
</head>
<body>
	<h2>Borrar Producto</h2>
	<form action="ProductoServlet" method="post">
		<input type="hidden" name="action" value="eliminar" /> <label
			for="nombre">Seleccione el producto a eliminar:</label> <select
			id="nombre" name="nombre" required>
			<%
			List<Producto> productos = (List<Producto>) request.getAttribute("productos");
			if (productos != null && !productos.isEmpty()) {
				for (Producto producto : productos) {
			%>
			<option value="<%=producto.getNombre()%>"><%=producto.getNombre()%></option>
			<%
			}
			} else {
			%>
			<option value="">No hay productos disponibles</option>
			<%
			}
			%>
		</select><br>
		<br>

		<button type="submit">Borrar Producto</button>
	</form>
	<a href="menu.jsp">Volver al Menú</a>
</body>
</html>