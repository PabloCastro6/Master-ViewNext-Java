<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu</title>
</head>
<body>
	<h2>Menú Principal</h2>
	<ul>
		<li><a href="listarProductos.jsp">Listar Productos</a></li>
		<li>
			<form action="ProductoServlet" method="post" style="display: inline;">
				<input type="hidden" name="action" value="mostrarEliminar" />
				<button type="submit"
					style="background: none; border: none; color: blue; text-decoration: underline; cursor: pointer;">
					Borrar Producto</button>
			</form>
		</li>
		<li><a href="agregarProducto.jsp">Agregar Producto</a></li>
		<li>
			<form action="ProductoServlet" method="post" style="display: inline;">
				<input type="hidden" name="action" value="mostrarModificar" />
				<button type="submit"
					style="background: none; border: none; color: blue; text-decoration: underline; cursor: pointer;">
					Modificar Producto</button>
			</form>
		</li>
		<li><a href="PedidoServlet?action=crear">Realizar Pedido</a></li>
	</ul>
</body>
</html>