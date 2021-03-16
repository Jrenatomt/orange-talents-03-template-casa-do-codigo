package br.com.zup.casaDoCodigo.validation;

import java.util.ArrayList;
import java.util.List;

public class ValidationError {
	
	private List<FieldMessage> errors = new ArrayList<>();

	public List<FieldMessage> getErrors() {
		return errors;
	}
	
	public void addError(String fildName, String message) {
		errors.add(new FieldMessage(fildName, message));
	}
}
