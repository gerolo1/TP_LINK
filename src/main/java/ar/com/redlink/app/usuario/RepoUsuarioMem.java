package ar.com.redlink.app.usuario;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import ar.com.redlink.app.RepeticionException;
import ar.com.redlink.domain.Usuario;

@Repository
public class RepoUsuarioMem implements RepoUsuario{
	
	private List<Usuario> usuarios;
	
	public RepoUsuarioMem() {
		super();
		usuarios = null;
	}
	
	public List<Usuario> all() {
		return this.usuarios;
	}
	
	public Boolean usuarioExistente(String nombre) {
		return this.usuarios.stream()
				.anyMatch(u -> u.getUsername() == nombre);
	}	
	
	public List<Usuario> findByName(String nombre) {
		return this.usuarios.stream()
				.filter(prod -> prod.getUsername() == nombre)
				.collect(Collectors.toList());
	}	
	
	public void agregarUsuario(Usuario usuario) throws RepeticionException {
		if(this.usuarios.contains(usuario)) {
			throw new RepeticionException();
		} else {
			this.usuarios.add(usuario);
		}
	}

}
