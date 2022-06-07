package ar.com.redlink.app.promocion;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import ar.com.redlink.app.RepeticionException;
import ar.com.redlink.domain.Promocion;

@Repository
public class RepoPromocionMem implements RepoPromocion {
	
	private List<Promocion> promociones;
	
	public RepoPromocionMem() {
		super();
		promociones = null;
	}
	
	public List<Promocion> all() {
		return this.promociones;
	}
	
	public Boolean promocionExistente(String nombre) {
		return this.promociones.stream()
				.anyMatch(p -> p.getNombre() == nombre);
	}
	
	public List<Promocion> findByName(String nombre) {
		return this.promociones.stream()
				.filter(p -> p.getNombre() == nombre)
				.collect(Collectors.toList());
	}
	
	public void agregarPromocion(Promocion promocion) throws RepeticionException {
		if(this.promociones.contains(promocion)) {
			throw new RepeticionException();
		} else {
			this.promociones.add(promocion);
		}
	}

}
