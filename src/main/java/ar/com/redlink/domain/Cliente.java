package ar.com.redlink.domain;

import java.util.List;

public class Cliente {
	
	private Usuario usuario;
	private List<Producto> carrito;
	private Promocion membresia;
	private OrdenDeCompra orden;
	
	public void agregarAlCarrito(Producto producto) {
		this.carrito.add(producto);
	}
	
	public void quitarDelCarrito(Producto producto) {
		this.carrito.remove(producto);
	}
	
	public void generarOrden(Promocion tipoDePago) {
		OrdenDeCompra miorden = new OrdenDeCompra(this.carrito, tipoDePago, this.membresia);
		this.orden = miorden;
	}
	
	
	public Cliente(Usuario u, List<Producto> c, Promocion p) {
		super();
		this.usuario = u;
		this.carrito = c;
		this.membresia = p;
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
	public OrdenDeCompra getOrden() {
		return orden;
	}
	public void setOrden(OrdenDeCompra orden) {
		this.orden = orden;
	}
	
}
