<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.almacen.modelo.Producto"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Realizar Pedido</title>
</head>
<body>
	<h2>Realizar Pedido</h2>
	<form action="PedidoServlet" method="post">
		<input type="hidden" name="action" value="crear" />

		<!-- Seleccionar nombre del producto -->
		<label for="nombreProducto">Seleccione el Producto:</label> <select
			id="nombreProducto" name="nombreProducto" required>
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
		</select><br> <br> <label for="categoria">Categoría:</label> <select
			id="categoria" name="categoria" required>
			<option value="ELECTRONICA">Electrónica</option>
			<option value="ACCESORIOS">Accesorios</option>
			<option value="ALIMENTOS">Alimentos</option>
			<!-- Agrega más opciones según el enum Categoria -->
		</select><br>
		<br> <br> <label for="precio">Precio:</label> <input
			type="number" step="0.01" id="precio" name="precio" required /><br>
		<br> <label for="stock">Stock:</label> <input type="number"
			id="stock" name="stock" required /><br> <br> <label
			for="cantidad">Cantidad para el Pedido:</label> <input type="number"
			id="cantidad" name="cantidad" min="1" required /><br> <br>

		<button type="submit">Realizar Pedido</button>
	</form>

	<a href="menu.jsp">Volver al Menú</a>
</body>
</html>
