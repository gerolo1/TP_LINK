package ar.com.redlink.domain;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Empleado {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotBlank
	private String nombre;
	@Transient @NotNull
	private Usuario usuario;
	@Transient
	private List<Producto> productos;
	@Min(0)
	private Integer cantidadCritica;
	
	public void agregarProducto(Producto producto) {
		
		this.productos.add(producto);
	}
	
	public void quitarProducto(Producto producto) {
		
		this.productos.remove(producto);
	}
	
	public void validarCompra(OrdenDeCompra odc) throws FaltanProductosException {
		List<Producto> productosCliente = odc.getPedido();
		if(productosCliente.containsAll(this.productos)) {

			//GENERAR MAIL DE COMPROBANTE
			
			this.productos.removeAll(productosCliente);
			Set<Producto> setProductosCliente = odc.getPedido().stream().collect(Collectors.toSet());
			if(setProductosCliente.stream().allMatch(prod -> this.comprobarStock(prod))) {
				this.notificarProveedor();
			}
		} else {
			throw new FaltanProductosException();
		}
	}
	
	private boolean comprobarStock(Producto producto) {
		
		List<Producto> productoUnico = this.productos.stream().filter(prod -> prod == producto).collect(Collectors.toList());
		return productoUnico.size() > this.cantidadCritica;
	}
	
	public void cambiarProveedor(Producto producto, Proveedor nuevoProveedor) {
		List<Producto> productosUnicos = this.productos.stream().filter(p -> p == producto).collect(Collectors.toList());
		this.productos.removeAll(productosUnicos);
		productosUnicos.forEach(p -> p.setProveedor(nuevoProveedor));
		this.productos = productosUnicos;
	}
	
	public void notificarProveedor() {
		// GENERAR MAIL AL PROVEEDOR
	}

	protected Empleado() {
		super();
	}
	
	public Empleado(String n, Usuario u, List<Producto> p) {
		this.nombre = n;
		this.usuario = u;
		this.productos = p;
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
	public List<Producto> getProductos() {
		return productos;
	}
	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	public Integer getLimiteDeAviso() {
		return cantidadCritica;
	}
	public void setLimiteDeAviso(Integer limiteDeAviso) {
		this.cantidadCritica = limiteDeAviso;
	}
	public Integer getId() {
		return id;
	}
	
}
