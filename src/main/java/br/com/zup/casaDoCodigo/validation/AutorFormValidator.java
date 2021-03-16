package br.com.zup.casaDoCodigo.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.zup.casaDoCodigo.entities.Autor;
import br.com.zup.casaDoCodigo.form.AutorForm;
import br.com.zup.casaDoCodigo.repositories.AutorRepository;

public class AutorFormValidator implements ConstraintValidator<AutorFormValid, AutorForm> {
	
	@Autowired
	private AutorRepository repository;
	
	@Override
	public void initialize(AutorFormValid ann) {
	}

	@Override
	public boolean isValid(AutorForm form, ConstraintValidatorContext context) {
		
		List<FieldMessage> list = new ArrayList<>();
		
		Autor email = repository.findByEmail(form.getEmail());
		
		if (email != null) {
			list.add(new FieldMessage("email", "e-mail já cadastrado"));
		}
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
} 
