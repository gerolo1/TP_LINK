package ar.com.redlink.app.empleado;

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
import ar.com.redlink.domain.Empleado;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {
	
	@Autowired
	private RepoEmpleado repoEmpleado;
	
	@GetMapping("")
	public Page<Empleado> get(@RequestParam(value = "nombre", required = false) String nombre) {

		if(nombre == "") {
			return new PageImpl<Empleado>(repoEmpleado.all());
		} else {
			return new PageImpl<Empleado>(repoEmpleado.findByUser(nombre));
		}
	}
	
	@PostMapping("")
	public void post(@RequestBody @Valid Empleado empleado, BindingResult bindingResult) throws RepeticionException {
		
		if(bindingResult.hasErrors()) {
			bindingResult.getFieldError();
		} else {
			repoEmpleado.agregarEmpleado(empleado);
		}
	}

}
