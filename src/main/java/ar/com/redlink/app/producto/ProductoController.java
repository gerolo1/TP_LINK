package ar.com.redlink.app.producto;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.com.redlink.app.InexistenciaException;
import ar.com.redlink.app.RepeticionException;
import ar.com.redlink.domain.Producto;

@RestController
@RequestMapping("/productos")
public class ProductoController {
	
	@Autowired
	private RepoProducto repo;
	
	@Value("${elementos.por.pagina}")
	private Integer elementosPorPagina;
	
	@GetMapping("")
	public Page<Producto> get(@RequestParam(value = "nombre", required = false) String nombre, Pageable page){
		
		if(nombre == null) {
			return repo.findAll(PageRequest.of(page.getPageNumber(), this.elementosPorPagina));
		} else {
			return repo.findByNombre(nombre, PageRequest.of(page.getPageNumber(), this.elementosPorPagina));
		}
	}
	
	@Transactional
	@PostMapping("")
	public void post(@RequestBody @Valid Producto producto, BindingResult bindingResult) throws RepeticionException {
		
		if(!bindingResult.hasErrors()) {
			repo.save(producto);
		} else {
			bindingResult.getFieldError();
		}
	}
	
	@Transactional
	@DeleteMapping("")
	public void delete(@RequestBody Producto producto) throws InexistenciaException {
		
		if(repo.existsById(producto.getId())) {
			repo.delete(producto);
		} else {
			throw new InexistenciaException();
		}
	}
}
