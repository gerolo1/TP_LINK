package ar.com.redlink.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class OrdenDeCompra {
	
	@OneToOne
	private Cliente cliente;
	@Id 
	private Integer id = cliente.getId();
	@ManyToMany
	private List<Producto> pedido;
	
	
	private Integer montoBruto() {
		int total = 0;
		for(int i=0; i < this.pedido.size(); i++) {
			total += this.pedido.get(i).getPrecio();
		}
		return total;
	}
	
	private Integer descuentoMembresia() {
		return this.montoBruto() * this.cliente.getMembresia().getDescuento();
	}
	
	private Integer descuentoMetodo() {
		return this.montoBruto() * this.cliente.getMetodoDePago().getDescuento();
	}
	
	private Integer descuentoCupon() {
		int total = 0;
		for(int i=0; i < this.pedido.size(); i++) {
			total += this.pedido.get(i).getProveedor().getCupon().getDescuento();
		}
		return total;
		
	}
	
	public Integer montoFinal() {
		return this.montoBruto() - this.descuentoMembresia() - this.descuentoMetodo() - this.descuentoCupon();
	}
	
	protected OrdenDeCompra() {
		super();
	}
	
	public OrdenDeCompra(Cliente cliente, List<Producto> pedido) {
		super();
		this.cliente = cliente;
		this.pedido = pedido;
		
	}

	public List<Producto> getPedido() {
		return pedido;
	}
	public void setPedido(List<Producto> pedido) {
		this.pedido = pedido;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}
