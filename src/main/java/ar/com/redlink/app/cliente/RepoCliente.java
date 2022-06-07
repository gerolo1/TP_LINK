package ar.com.redlink.app.cliente;

import java.util.List;

import ar.com.redlink.app.RepeticionException;
import ar.com.redlink.domain.Cliente;

public interface RepoCliente {
	
	public List<Cliente> all();
	
	public Boolean clienteExistente(String nombre);
	
	public List<Cliente> findByUser(String nombre);
	
	public void agregarCliente(Cliente cliente) throws RepeticionException;

}
