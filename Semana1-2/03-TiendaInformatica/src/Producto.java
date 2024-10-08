
public abstract class Producto {
     private String codigoProducto;
     private String modelo;
     private double precio;
     private int cantidad;

    // Constructor
    public Producto(String codigoProducto, String modelo, double precio, int cantidad) {
        super();
    	this.codigoProducto = codigoProducto;
        this.modelo = modelo;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    
    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    // Método toString
    @Override
    public String toString() {
        return "Producto [Código: " + codigoProducto + ", Modelo: " + modelo + ", Precio: " + precio + ", Cantidad: " + cantidad + "]";
    }
}
