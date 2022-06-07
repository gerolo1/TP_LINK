package ar.com.redlink.app.producto;

import java.awt.print.Pageable;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.PathVariable; se usa como buscador en URL
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.com.redlink.app.RepeticionException;
import ar.com.redlink.domain.Producto;

@RestController
@RequestMapping("/productos")
public class ProductoController {
	
	@Autowired
	private RepoProducto repoProducto;
	
	@Value("${productos.por.pagina}")
	private int productosPorPagina;
	
	@GetMapping("")
	public Page<Producto> get(@RequestParam(value = "nombre", required = false) String nombre, Pageable page){
		
		if(nombre == "") {
			return new PageImpl<Producto>(repoProducto.clasificar(repoProducto.all(), page, this.productosPorPagina));
		} else {
			return new PageImpl<Producto>(repoProducto.clasificar(repoProducto.findByName(nombre), page, this.productosPorPagina));
		}
	}
	
	@PostMapping("")
	public void post(@RequestBody @Valid Producto producto, BindingResult bindingResult) throws RepeticionException {
		
		if(bindingResult.hasErrors()) {
			bindingResult.getFieldError();
		} else {
			repoProducto.agregarProducto(producto);
		}
	}
}
