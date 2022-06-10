package ar.com.redlink.domain;

public class Promocion {
	
	//@Id @GeneratedValue(strategy = GenerationType.AUTO)
	//private Integer id;
	
	private String nombre;
	private Integer descuento;
	
	
	public Promocion(String n, int d) {
		this.nombre = n;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getDescuento() {
		return descuento;
	}
	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}
	
}
