package ar.com.redlink.app.usuario;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import ar.com.redlink.domain.Usuario;

public interface RepoUsuario extends PagingAndSortingRepository<Usuario, Integer>  {
	
	Page<Usuario> findByUsername(String user, Pageable page);
}
