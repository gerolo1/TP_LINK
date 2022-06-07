package ar.com.redlink.app.producto;

import java.awt.print.Pageable;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import ar.com.redlink.app.RepeticionException;
import ar.com.redlink.domain.Producto;

@Repository
public class RepoProductoMem implements RepoProducto {
	
	private List<Producto> productos;
	
	public RepoProductoMem() {
		super();
		productos = null; //INTEGRAR DB
	}
	
	public List<Producto> all() {
		return productos;
	}
	
	public List<Producto> findByName(String nombre) {
		
		return this.productos.stream()
				.filter(p -> p.getNombre() == nombre)
				.collect(Collectors.toList());
	}
	
	public List<Producto> clasificar(List<Producto> lista, Pageable page, int cantidadDePaginas) {
		return lista.subList((page.getNumberOfPages() - 1) * cantidadDePaginas, page.getNumberOfPages() * cantidadDePaginas - 1);
	}
	
	public void agregarProducto(Producto producto) throws RepeticionException {
		if (this.productos.contains(producto)) {
			throw new RepeticionException();
		} else {
			this.productos.add(producto);
		}
	}

}
