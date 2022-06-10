package ar.com.redlink.app.odc;

import org.springframework.data.repository.PagingAndSortingRepository;
import ar.com.redlink.domain.OrdenDeCompra;

public interface RepoODC extends PagingAndSortingRepository<OrdenDeCompra, Integer> {
	
	

}
