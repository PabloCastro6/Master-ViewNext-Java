<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.almacen.modelo.Producto"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestion de Productos</title>
</head>
<body>
	<h2>Lista de Productos</h2>
	<table border="1">
		<tr>
			<th>Nombre</th>
			<th>Categoría</th>
			<th>Precio</th>
			<th>Stock</th>
			<th>Acciones</th>
		</tr>
		<%
		List<Producto> productos = (List<Producto>) request.getAttribute("productos");
		if (productos != null && !productos.isEmpty()) {
			for (Producto producto : productos) {
		%>
		<tr>
			<td><%=producto.getNombre()%></td>
			<td><%=producto.getCategoria()%></td>
			<td><%=producto.getPrecio()%></td>
			<td><%=producto.getStock()%></td>
			<td>
				<!-- Formulario para eliminar producto -->
				<form action="ProductoServlet" method="post"
					style="display: inline;">
					<input type="hidden" name="action" value="eliminar" /> <input
						type="hidden" name="nombre" value="<%=producto.getNombre()%>" />
					<button type="submit">Eliminar</button>
				</form> <!-- Enlace para modificar producto --> <a
				href="editarProducto.jsp?nombre=<%=producto.getNombre()%>">Modificar</a>
			</td>
		</tr>
		<%
		}
		} else {
		%>
		<tr>
			<td colspan="5">No hay productos disponibles.</td>
		</tr>
		<%
		}
		%>
	</table>
	<a href="agregarProducto.jsp">Agregar Nuevo Producto</a>
</body>
</html>
>
