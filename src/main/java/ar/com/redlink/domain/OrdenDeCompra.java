package ar.com.redlink.domain;

import java.util.List;

public class OrdenDeCompra {
	
	private List<Producto> pedido;
	private Promocion metodoDePago;
	private Promocion membresia;
	
	private Integer montoBruto() {
		int total = 0;
		for(int i=0; i < this.pedido.size(); i++) {
			total += this.pedido.get(i).getPrecio();
		}
		return total;
	}
	
	private Integer descuentoMembresia() {
		return this.montoBruto() * this.membresia.getDescuento();
	}
	
	private Integer descuentoMetodo() {
		return this.montoBruto() * this.metodoDePago.getDescuento();
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
	
	
	
	public OrdenDeCompra(List<Producto> pedido, Promocion metodoDePago, Promocion membresia) {
		super();
		this.pedido = pedido;
		this.metodoDePago = metodoDePago;
		this.membresia = membresia;
	}

	public Promocion getMetodoDePago() {
		return metodoDePago;
	}
	public void setMetodoDePago(Promocion metodoDePago) {
		this.metodoDePago = metodoDePago;
	}
	public List<Producto> getPedido() {
		return pedido;
	}
	public void setPedido(List<Producto> pedido) {
		this.pedido = pedido;
	}
	public Promocion getMembresia() {
		return membresia;
	}
	public void setMembresia(Promocion membresia) {
		this.membresia = membresia;
	}
	
}
