package ar.com.redlink.app.producto;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import ar.com.redlink.domain.Producto;

public interface RepoProducto extends PagingAndSortingRepository<Producto, Integer> {
	
	Page<Producto> findByNombre(String nombre, Pageable page);

}
