package ar.com.redlink.app.cliente;

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
import ar.com.redlink.domain.Cliente;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private RepoCliente repoCliente;
	
	@GetMapping("")
	public Page<Cliente> get(@RequestParam(value = "nombre", required = false) String nombre) {

		if(nombre == "") {
			return new PageImpl<Cliente>(repoCliente.all());
		} else {
			return new PageImpl<Cliente>(repoCliente.findByUser(nombre));
		}
	}
	
	@PostMapping("")
	public void post(@RequestBody @Valid Cliente cliente, BindingResult bindingResult) throws RepeticionException {
		
		if(bindingResult.hasErrors()) {
			bindingResult.getFieldError();
		} else {
			repoCliente.agregarCliente(cliente);
		}
	}

}
