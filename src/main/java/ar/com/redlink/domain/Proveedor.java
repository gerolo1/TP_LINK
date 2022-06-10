package ar.com.redlink.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

@Entity
public class Proveedor {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotBlank
	private String nombre;
	@OneToOne
	private Promocion cupon;
	
	
	protected Proveedor() {
		super();
	}
	public Integer getId() {
		return id;
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
