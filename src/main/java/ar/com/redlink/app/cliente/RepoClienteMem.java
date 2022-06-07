package ar.com.redlink.app.cliente;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import ar.com.redlink.app.RepeticionException;
import ar.com.redlink.domain.Cliente;

@Repository
public class RepoClienteMem implements RepoCliente {

	private List<Cliente> clientes;
	
	public RepoClienteMem() {
		super();
		clientes = null;
	}
	
	public List<Cliente> all() {
		return this.clientes;
	}
	
	public Boolean clienteExistente(String nombre) {
		return this.clientes.stream()
				.anyMatch(c -> c.getUsuario().getUsername() == nombre);
	}
	
	public List<Cliente> findByUser(String nombre) {
		return this.clientes.stream()
				.filter(c -> c.getUsuario().getUsername() == nombre)
				.collect(Collectors.toList());
	}
	
	public void agregarCliente(Cliente cliente) throws RepeticionException {
		if(this.clientes.contains(cliente)) {
			throw new RepeticionException();
		} else {
			this.clientes.add(cliente);
		}
	}
	
	
}
