package ar.com.redlink.domain;

public class Promocion {

	private String nombre;
	private int descuento;
	
	
	public Promocion(String n, int d) {
		this.nombre = n;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getDescuento() {
		return descuento;
	}
	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}
	
}
