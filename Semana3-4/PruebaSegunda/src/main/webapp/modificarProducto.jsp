<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.almacen.modelo.Producto"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Modificar Producto</title>
</head>
<body>
	<h2>Modificar Producto</h2>
	<form action="ProductoServlet" method="post">
		<input type="hidden" name="action" value="modificar" /> <label
			for="nombre">Seleccione el Producto:</label> <select id="nombre"
			name="nombre" required>
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
		<br> <label>Campo a Modificar:</label><br> <input
			type="radio" name="campo" value="nombre" required> Nombre<br>
		<input type="radio" name="campo" value="categoria"> Categoría<br>
		<input type="radio" name="campo" value="precio"> Precio<br>
		<input type="radio" name="campo" value="stock"> Stock<br>
		<br> <label for="nuevoValor">Nuevo Valor:</label> <input
			type="text" id="nuevoValor" name="nuevoValor" required /><br>
		<br>

		<button type="submit">Modificar Producto</button>
	</form>

	<a href="menu.jsp">Volver al Menú</a>
</body>
</html>
