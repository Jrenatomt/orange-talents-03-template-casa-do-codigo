package br.com.zup.casaDoCodigo.controller;

import javax.validation.Valid;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casaDoCodigo.entities.Autor;
import br.com.zup.casaDoCodigo.form.AutorForm;
import br.com.zup.casaDoCodigo.repositories.AutorRepository;

@RestController
@RequestMapping(value = "/autores")
public class AutorController {
	
	private final AutorRepository repository;
	
	public AutorController(AutorRepository repository) {
		this.repository = repository;
	}
	
	@PostMapping
	@Transactional
	public void CadastrarAutor(@RequestBody @Valid AutorForm form){
		Autor novoAutor = form.novoAutor();
		repository.save(novoAutor);
	}
}
