
public class Telefono extends Producto {
     String operador;

    // Constructor
    public Telefono(String codigoProducto, String modelo, double precio, int cantidad, String operador) {
        super(codigoProducto, modelo, precio, cantidad);
        this.operador = operador;
    }

   
    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    // Método toString
    @Override
    public String toString() {
        return "Teléfono Móvil [Código: " + getCodigoProducto() + ", Modelo: " + getModelo() + ", Precio: " + getPrecio() +
               ", Cantidad: " + getCantidad() + ", Operador: " + operador + "]";
    }
}

