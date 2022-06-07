package ar.com.redlink.domain;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Producto {
	
	@NotBlank
	private String nombre;
	@Min(0)
	private int precio;
	@NotNull
	private Proveedor proveedor;
	
	
	public Producto(String n, int pre, Proveedor pro) {
		this.nombre = n;
		this.precio = pre;
		this.proveedor = pro;
	}
	public Proveedor getProveedor() {
		return proveedor;
	}
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
