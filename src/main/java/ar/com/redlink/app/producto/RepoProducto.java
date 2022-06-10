package ar.com.redlink.app.producto;

import java.awt.print.Pageable;
import java.util.List;

import ar.com.redlink.app.RepeticionException;
import ar.com.redlink.domain.Producto;

public interface RepoProducto {
	
	public List<Producto> all();
	
	public void agregarProducto(Producto producto) throws RepeticionException;
	
	public List<Producto> clasificar(List<Producto> lista, Pageable page, Integer cantidadDePaginas);
	
	public List<Producto> findByName(String nombreProd);

}
