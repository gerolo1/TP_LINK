package ar.com.redlink.app.empleado;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import ar.com.redlink.domain.Empleado;

public interface RepoEmpleado extends PagingAndSortingRepository<Empleado, Integer> {
	
	Page<Empleado> findByNombre(String nombre, Pageable page);

}
