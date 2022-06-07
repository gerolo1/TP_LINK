package ar.com.redlink.app.promocion;

import java.util.List;

import ar.com.redlink.app.RepeticionException;
import ar.com.redlink.domain.Promocion;

public interface RepoPromocion {

	public List<Promocion> all();
	
	public Boolean promocionExistente(String nombre);
	
	public List<Promocion> findByName(String nombre);
	
	public void agregarPromocion(Promocion promocion) throws RepeticionException;

}
