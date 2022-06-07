package ar.com.redlink.app.empleado;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import ar.com.redlink.app.RepeticionException;
import ar.com.redlink.domain.Empleado;

@Repository
public class RepoEmpleadoMem implements RepoEmpleado {

	private List<Empleado> empleados;
	
	public RepoEmpleadoMem() {
		super();
		empleados = null;
	}
	
	public List<Empleado> all() {
		return this.empleados;
	}
	
	public Boolean empleadoExistente(String nombre) {
		return this.empleados.stream()
				.anyMatch(e -> e.getUsuario().getUsername() == nombre);
	}
	
	public List<Empleado> findByUser(String nombre) {
		return this.empleados.stream()
				.filter(e -> e.getUsuario().getUsername() == nombre)
				.collect(Collectors.toList());
	}
	
	public void agregarEmpleado(Empleado empleado) throws RepeticionException {
		if(this.empleados.contains(empleado)) {
			throw new RepeticionException();
		} else {
			this.empleados.add(empleado);
		}
	}
}
