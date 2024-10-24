
public class Ordenador extends Producto {
     private String procesador;
     private int memoria;
     private int discoDuro;

    // Constructor
    public Ordenador(String codigoProducto, String modelo, double precio, int cantidad, String procesador, int memoria, int discoDuro) {
        super(codigoProducto, modelo, precio, cantidad);
        this.procesador = procesador;
        this.memoria = memoria;
        this.discoDuro = discoDuro;
    }

   
    public String getProcesador() {
        return procesador;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

    public int getMemoria() {
        return memoria;
    }

    public void setMemoria(int memoria) {
        this.memoria = memoria;
    }

    public int getDiscoDuro() {
        return discoDuro;
    }

    public void setDiscoDuro(int discoDuro) {
        this.discoDuro = discoDuro;
    }

    // Método toString
    @Override
    public String toString() {
        return "Ordenador [Código: " + getCodigoProducto() + ", Modelo: " + getModelo() + ", Precio: " + getPrecio() +
               ", Cantidad: " + getCantidad() + ", Procesador: " + procesador + ", Memoria: " + memoria +
               "GB, Disco Duro: " + discoDuro + "GB]";
    }
}
