<form action="ProductoServlet" method="post">
    <input type="hidden" name="action" value="alta"/>
    
    <label for="nombre">Nombre:</label>
    <input type="text" id="nombre" name="nombre" required/><br><br>
    
    <label for="categoria">Categoría:</label>
    <select id="categoria" name="categoria">
        <option value="ELECTRONICA">Electrónica</option>
        <option value="ACCESORIOS">Accesorios</option>
        <option value="ROPA">Ropa</option>
        <option value="HOGAR">Hogar</option>
        <option value="ALIMENTOS">Alimentos</option>
    </select><br><br>
    
    <label for="precio">Precio:</label>
    <input type="number" id="precio" name="precio" step="0.01" min="0" required/><br><br>
    
    <label for="stock">Stock:</label>
    <input type="number" id="stock" name="stock" min="0" required/><br><br>
    
    <button type="submit">Guardar Producto</button>
</form>
