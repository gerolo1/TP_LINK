package ar.com.redlink.domain;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Empleado {
	
	private Usuario usuario;
	private List<Producto> productos;
	private int limiteDeAviso;
	
	public void agregarProducto(Producto producto) {
		
		this.productos.add(producto);
	}
	
	public void quitarProducto(Producto producto) {
		
		this.productos.remove(producto);
	}
	
	public void validarCompra(Cliente cliente) throws FaltanProductosException {
		List<Producto> productosCliente = cliente.getOrden().getPedido();
		if(productosCliente.containsAll(this.productos)) {

			//GENERAR MAIL DE COMPROBANTE
			
			this.productos.removeAll(productosCliente);
			Set<Producto> setProductosCliente = cliente.getOrden().getPedido().stream().collect(Collectors.toSet());
			if(setProductosCliente.stream().allMatch(prod -> this.comprobarStock(prod))) {
				this.notificarProveedor();
			}
		} else {
			throw new FaltanProductosException();
		}
	}
	
	private boolean comprobarStock(Producto producto) {
		
		List<Producto> productoUnico = this.productos.stream().filter(prod -> prod == producto).collect(Collectors.toList());
		return productoUnico.size() > this.limiteDeAviso;
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

	
	public Empleado(Usuario u, List<Producto> p) {
		this.usuario = u;
		this.productos = p;
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
	public int getLimiteDeAviso() {
		return limiteDeAviso;
	}
	public void setLimiteDeAviso(int limiteDeAviso) {
		this.limiteDeAviso = limiteDeAviso;
	}
	
}
