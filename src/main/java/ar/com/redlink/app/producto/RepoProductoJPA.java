package ar.com.redlink.app.producto;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import ar.com.redlink.app.RepeticionException;
import ar.com.redlink.domain.Producto;

@Repository
@Qualifier("jpa")
public class RepoProductoJPA implements RepoProducto {
	
	@Autowired
	private RepoProductoSpring repo;
	
	public List<Producto> all() {
		return (List<Producto>) repo.findAll();
	}
	
	public List<Producto> findByName(String nombre) {
		return repo.findByNombre(nombre);
	}
	
	public List<Producto> clasificar(List<Producto> lista, Pageable page, Integer cantidadDePaginas) {
		return lista.subList(page.getNumberOfPages() * cantidadDePaginas, page.getNumberOfPages() * cantidadDePaginas + page.getNumberOfPages());
	}
	
	public void agregarProducto(Producto producto) throws RepeticionException {
		//if (this.productos.contains(producto)) {
		//	throw new RepeticionException();
		//} else {
			repo.save(producto);
		//}
	}

}
