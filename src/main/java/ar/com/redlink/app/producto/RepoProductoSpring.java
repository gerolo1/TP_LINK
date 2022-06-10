package ar.com.redlink.app.producto;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;

import ar.com.redlink.domain.Producto;

@Qualifier("dbspring")
public interface RepoProductoSpring extends CrudRepository<Producto, Integer> {
	
	List<Producto> findByNombre(String nombre);

}
