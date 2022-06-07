package ar.com.redlink.app.promocion;

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
import ar.com.redlink.domain.Promocion;

@RestController
@RequestMapping("/promociones")
public class PromocionController {
	
	@Autowired
	private RepoPromocion repoPromocion;
	
	@GetMapping("")
	public Page<Promocion> get(@RequestParam(value = "nombre", required = false) String nombre) {

		if(nombre == "") {
			return new PageImpl<Promocion>(repoPromocion.all());
		} else {
			return new PageImpl<Promocion>(repoPromocion.findByName(nombre));
		}
	}
	
	@PostMapping("")
	public void post(@RequestBody @Valid Promocion promocion, BindingResult bindingResult) throws RepeticionException {
		
		if(bindingResult.hasErrors()) {
			bindingResult.getFieldError();
		} else {
			repoPromocion.agregarPromocion(promocion);
		}
	}

}
