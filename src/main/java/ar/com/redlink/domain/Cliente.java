package ar.com.redlink.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Cliente {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotBlank
	private String nombre;
	@OneToOne @NotNull
	private Usuario usuario;
	@ManyToMany
	private List<Producto> carrito;
	@ManyToOne @NotNull
	private Promocion membresia;
	@ManyToOne @NotNull
	private Promocion metodoDePago;
	
	public void agregarAlCarrito(Producto producto) {
		this.carrito.add(producto);
	}
	
	public void quitarDelCarrito(Producto producto) {
		this.carrito.remove(producto);
	}
	
	protected Cliente() {
		super();
	}
	
	public Cliente(String n, Usuario u, List<Producto> c, Promocion m) {
		super();
		this.nombre = n;
		this.usuario = u;
		this.carrito = c;
		this.membresia = m;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Promocion getMembresia() {
		return membresia;
	}
	public void setMembresia(Promocion membresia) {
		this.membresia = membresia;
	}
	public List<Producto> getCarrito() {
		return carrito;
	}
	public void setCarrito(List<Producto> carrito) {
		this.carrito = carrito;
	}
	public Integer getId() {
		return id;
	}
	public Promocion getMetodoDePago() {
		return metodoDePago;
	}
	public void setMetodoDePago(Promocion metodoDePago) {
		this.metodoDePago = metodoDePago;
	}
	
}
