package br.com.zup.casaDoCodigo.controller;

import javax.validation.Valid;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casaDoCodigo.entities.Categoria;
import br.com.zup.casaDoCodigo.form.CategoriaForm;
import br.com.zup.casaDoCodigo.repositories.CategoriaRepository;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {
	
	private final CategoriaRepository repository;

	public CategoriaController(CategoriaRepository repository) {
		this.repository = repository;
	}
	
    @PostMapping
    @Transactional
	public String cadastrarCategoria(@RequestBody @Valid CategoriaForm form) {
		Categoria novaCategoria = new Categoria(form.getNome());
		repository.save(novaCategoria);
		return novaCategoria.toString();	
	}
}
