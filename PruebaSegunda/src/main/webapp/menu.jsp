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
        <li><a href="ProductoServlet?action=listar">Listar Productos</a></li>
        <li><a href="buscarProducto.html">Buscar Producto</a></li>
        <li><a href="agregarProducto.html">Agregar Producto</a></li>
        <li><a href="modificarProducto.html">Modificar Producto</a></li>
        <li><a href="borrarProducto.html">Borrar Producto</a></li>
        <li><a href="PedidoServlet?action=crear">Realizar Pedido</a></li>
    </ul>
</body>
</html>