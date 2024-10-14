<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>     
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agregar Producto</title>
</head>
<body>
 <h2>Agregar o Modificar Producto</h2>
    <form action="ProductoServlet" method="post">
       
        <input type="hidden" name="action" value="alta"/> 
        
       
        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" name="nombre" required/><br><br>
        
        
        <label for="categoria">Categoría:</label>
        <input type="text" id="categoria" name="categoria" required/><br><br>
        
        
        <label for="precio">Precio:</label>
        <input type="number" id="precio" name="precio" step="0.01" min="0" required/><br><br>
        
        
        <label for="stock">Stock:</label>
        <input type="number" id="stock" name="stock" min="0" required/><br><br>
        
        <button type="submit">Guardar Producto</button>
    </form>
</body>
</html>