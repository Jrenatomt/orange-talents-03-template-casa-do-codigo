package br.com.zup.casaDoCodigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casaDoCodigo.entities.Categoria;
import br.com.zup.casaDoCodigo.form.CategoriaForm;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {
	
	@PersistenceContext
	private EntityManager manager;

	@PostMapping
    @Transactional
	public String cadastrarCategoria(@RequestBody @Valid CategoriaForm form) {
		Categoria novaCategoria = new Categoria(form.getNome());
		manager.persist(novaCategoria);
		return novaCategoria.toString();	
	}
}
