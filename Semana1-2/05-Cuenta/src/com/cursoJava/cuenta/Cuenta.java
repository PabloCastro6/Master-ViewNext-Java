package com.cursoJava.cuenta;

public class Cuenta {
	private String titular;
	private double cantidad;
	
	
	public Cuenta (String titular) {
		super();
		this.titular = titular;
		this.cantidad = 0;
	}


	public Cuenta(String titular, double cantidad) {
		this.titular = titular;
		this.cantidad = cantidad;
		
		if(cantidad < 0) {
			this.cantidad = 0; 
			}else {
				this.cantidad = cantidad;
		}
	}


	public String getTitular() {
		return titular;
	}

// Ya que no se puede reasignar, no es necesario. 
//	public void setTitular(String titular) {
//		this.titular = titular;
//	}


	public double getCantidad() {
		return cantidad;
	}


	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}


	@Override
	public String toString() {
		return "Cuenta [titular=" + titular + ", cantidad=" + cantidad + "]";
	}
	
	
	// Método ingresar(double cantidad)
    public void ingresar(double cantidad) {
        if (cantidad > 0) {
            this.cantidad += cantidad;
        }
    }

    // Método retirar(double cantidad)
    public void retirar(double cantidad) {
        if (this.cantidad - cantidad < 0) {
            this.cantidad = 0;
        } else {
            this.cantidad -= cantidad;
        }
    }
}
	

