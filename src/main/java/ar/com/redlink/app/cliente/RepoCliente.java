package ar.com.redlink.app.cliente;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import ar.com.redlink.domain.Cliente;

public interface RepoCliente extends PagingAndSortingRepository<Cliente, Integer> {
	
	Page<Cliente> findByNombre(String mail, Pageable page);

}
