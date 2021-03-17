package br.com.zup.casaDoCodigo.validation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zup.casaDoCodigo.entities.Categoria;
import br.com.zup.casaDoCodigo.form.CategoriaForm;
import br.com.zup.casaDoCodigo.repositories.CategoriaRepository;

@Component
public class NomeCategoriaUnicoValidator implements Validator {

	@Autowired
	private CategoriaRepository repository;

	@Override
	public boolean supports(Class<?> clazz) {
		return CategoriaForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}

		CategoriaForm form = (CategoriaForm) target;

		Optional<Categoria> categoria = repository
				.findByNome(form.getNome());

		if (categoria.isPresent()) {
			errors.rejectValue("nome", null,
					"Já existe uma categoria com o nome "
							+ form.getNome());
		}
	}
}
