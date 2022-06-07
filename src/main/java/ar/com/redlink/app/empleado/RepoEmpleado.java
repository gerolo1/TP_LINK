package ar.com.redlink.app.empleado;

import java.util.List;

import ar.com.redlink.app.RepeticionException;
import ar.com.redlink.domain.Empleado;

public interface RepoEmpleado {
	
	public List<Empleado> all();
	
	public Boolean empleadoExistente(String nombre);
	
	public List<Empleado> findByUser(String nombre);
	
	public void agregarEmpleado(Empleado empleado) throws RepeticionException;

}
