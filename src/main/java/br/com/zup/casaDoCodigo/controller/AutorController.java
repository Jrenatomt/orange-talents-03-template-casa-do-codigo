package br.com.zup.casaDoCodigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casaDoCodigo.entities.Autor;
import br.com.zup.casaDoCodigo.form.AutorForm;

@RestController
@RequestMapping(value = "/autores")
public class AutorController {
	
	@PersistenceContext
    private EntityManager manager;
	
	@PostMapping
	@Transactional
	public String cadastrarAutor(@RequestBody @Valid AutorForm form){
		Autor novoAutor = form.converterNovoAutor();
		manager.persist(novoAutor);
		return novoAutor.toString();
   }
}
