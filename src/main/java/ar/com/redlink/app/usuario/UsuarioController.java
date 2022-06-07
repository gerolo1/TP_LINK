package ar.com.redlink.app.usuario;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.com.redlink.app.RepeticionException;
import ar.com.redlink.domain.Usuario;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private RepoUsuario repoUsuario;
	
	@GetMapping("")
	public Page<Usuario> get(@RequestParam(value = "nombre", required = false) String nombre) {
		
		if(nombre == "") {
			return new PageImpl<Usuario>(repoUsuario.all());
		} else {
			return new PageImpl<Usuario>(repoUsuario.findByName(nombre));
		}
	}
	
	@PostMapping("")
	public void post(@RequestBody @Valid Usuario usuario, BindingResult bindingResult) throws RepeticionException {
		if(bindingResult.hasErrors()) {
			bindingResult.getFieldError();
		} else {
			repoUsuario.agregarUsuario(usuario);
		}
	}
	
}
