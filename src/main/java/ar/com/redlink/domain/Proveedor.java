package ar.com.redlink.domain;

public class Proveedor {
	
	private String nombre;
	private Promocion cupon;
	
	
	public Proveedor(String n, Promocion p) {
		this.nombre = n;
		this.cupon = p;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Promocion getCupon() {
		return cupon;
	}
	public void setCupon(Promocion cupon) {
		this.cupon = cupon;
	}
	
}
