package ar.com.redlink.app;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(RepeticionException.class)
	@ResponseBody
	public String elementoRepetido(RepeticionException ex) {
		return "El elemento ingresado ya existe...";
	}
	
	@ExceptionHandler(InexistenciaException.class)
	@ResponseBody
	public String elementoInexistente(InexistenciaException ex) {
		return "El elemento ingresado no existe...";
	}
	
}