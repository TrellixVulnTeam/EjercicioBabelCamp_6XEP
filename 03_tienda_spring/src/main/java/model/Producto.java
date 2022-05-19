package model;

public class Producto {
	private String nombre;
	private String seccion;
	private Number precio;
	private Integer stock;
	
	public Producto(String nombre, String seccion, Number precio, Integer stock) {
		super();
		this.nombre = nombre;
		this.seccion = seccion;
		this.precio = precio;
		this.stock = stock;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getSeccion() {
		return seccion;
	}
	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}
	public Number getPrecio() {
		return precio;
	}
	public void setPrecio(Number precio) {
		this.precio = precio;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	
	
}
