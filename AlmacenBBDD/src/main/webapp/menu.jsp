<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menú Principal</title>
</head>
<body>
	<h1>Gestión de Productos del Almacén</h1>
	<ul>
		<li><a href="agregarProductos.jsp">Agregar Producto</a></li>
		<form action="ProductoServlet" method="post" style="display:inline;">
    <form action="ProductoServlet" method="post" style="display:inline;">
            <input type="hidden" name="action" value="listar">
            <a href="#" onclick="this.closest('form').submit(); return false;">Listar Productos</a> <!--  enlace funcione como un disparador para el formulario POST -->
        </form>

		 <li><a href="buscarProducto.jsp">Buscar Producto</a></li>
		<li><a href="modificarProducto.jsp">Modificar Producto</a></li>
		<li><a href="eliminarProducto.jsp">Eliminar Producto</a></li>
	</ul>
</body>
</html>
