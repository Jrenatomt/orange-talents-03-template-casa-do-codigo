package br.com.zup.casaDoCodigo.validation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ValidationExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ValidationError> validation(MethodArgumentNotValidException e) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		ValidationError erro = new ValidationError();
		
		for (FieldError f : e.getBindingResult().getFieldErrors()) {
			erro.addError(f.getField(), f.getDefaultMessage());
		}
		return ResponseEntity.status(status).body(erro);
	}

}