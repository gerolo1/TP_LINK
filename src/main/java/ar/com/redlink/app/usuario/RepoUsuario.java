package ar.com.redlink.app.usuario;

import java.util.List;

import ar.com.redlink.app.RepeticionException;
import ar.com.redlink.domain.Usuario;

public interface RepoUsuario {
	
	public List<Usuario> all();
	
	public Boolean usuarioExistente(String nombre);
	
	public List<Usuario> findByName(String nombre);
	
	public void agregarUsuario(Usuario usuario) throws RepeticionException;
}
