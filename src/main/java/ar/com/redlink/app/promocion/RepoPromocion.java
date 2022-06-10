package ar.com.redlink.app.promocion;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import ar.com.redlink.domain.Promocion;

public interface RepoPromocion extends PagingAndSortingRepository<Promocion, Integer> {

	Page<Promocion> findByNombre(String nombre, Pageable page);

}
