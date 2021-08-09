package ec.edu.ups.Mercado.ser.modelo;

public class CarritoCliente {
	private String nombreProd;
	private int cantidad;
	private double precio;
	private double total;
	private int productos;
	public String getNombreProd() {
		return nombreProd;
	}
	public void setNombreProd(String nombreProd) {
		this.nombreProd = nombreProd;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public int getProductos() {
		return productos;
	}
	public void setProductos(int productos) {
		this.productos = productos;
	}
	
	
}
