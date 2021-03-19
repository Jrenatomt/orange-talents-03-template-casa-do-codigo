package br.com.zup.casaDoCodigo.controller;

import javax.validation.Valid;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casaDoCodigo.entities.Pais;
import br.com.zup.casaDoCodigo.form.PaisForm;
import br.com.zup.casaDoCodigo.repositories.PaisRepository;

@RestController
@RequestMapping(value = "/paises")
public class PaisController {
	
	private final PaisRepository repository;
	
	public PaisController(PaisRepository repository) {
		this.repository = repository;
	}

	@PostMapping
	@Transactional
	public String cadastrarPais(@RequestBody @Valid PaisForm form) {
		Pais novoPais = form.toModel();
		repository.save(novoPais);
		return novoPais.toString();
	}
}
