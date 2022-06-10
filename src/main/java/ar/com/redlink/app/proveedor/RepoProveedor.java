package ar.com.redlink.app.proveedor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import ar.com.redlink.domain.Proveedor;

public interface RepoProveedor extends PagingAndSortingRepository<Proveedor, Integer> {
	
	Page<Proveedor> findByNombre(String nombre, Pageable page);

}
