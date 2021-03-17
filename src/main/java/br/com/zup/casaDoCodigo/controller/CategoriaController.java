package br.com.zup.casaDoCodigo.controller;

import javax.validation.Valid;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casaDoCodigo.entities.Categoria;
import br.com.zup.casaDoCodigo.form.CategoriaForm;
import br.com.zup.casaDoCodigo.repositories.CategoriaRepository;
import br.com.zup.casaDoCodigo.validation.NomeCategoriaUnicoValidator;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {
	
	private final CategoriaRepository repository;
	private final NomeCategoriaUnicoValidator nomeCategoriaUnicoValidator;

	public CategoriaController(CategoriaRepository repository, NomeCategoriaUnicoValidator nomeCategoriaUnicoValidator) {
		this.repository = repository;
		this.nomeCategoriaUnicoValidator = nomeCategoriaUnicoValidator;
	}
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(nomeCategoriaUnicoValidator);
	}

    @PostMapping
    @Transactional
	public String cadastrarCategoria(@RequestBody @Valid CategoriaForm form) {
		Categoria novaCategoria = new Categoria(form.getNome());
		repository.save(novaCategoria);
		return novaCategoria.toString();	
	}
}
