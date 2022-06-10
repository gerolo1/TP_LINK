package ar.com.redlink.app.odc;

import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.com.redlink.app.InexistenciaException;
import ar.com.redlink.app.RepeticionException;
import ar.com.redlink.domain.OrdenDeCompra;

@RestController
@RequestMapping("/compra")
public class ODCController {

	@Autowired
	private RepoODC repo;
	
	@GetMapping("")
	public Optional<OrdenDeCompra> get(@RequestParam(value = "clienteID", required = true) Integer clienteID) throws InexistenciaException{
		
		if(repo.existsById(clienteID)) {
			throw new InexistenciaException();
		} else {
			return repo.findById(clienteID);
		}
	}
	
	@Transactional
	@PostMapping("")
	public void post(@RequestBody @Valid OrdenDeCompra odc, BindingResult bindingResult) throws RepeticionException {
		
		if(!bindingResult.hasErrors()) {
			repo.save(odc);
		} else {
			bindingResult.getFieldError();
		}
	}
}
