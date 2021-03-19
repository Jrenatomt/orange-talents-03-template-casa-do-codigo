package br.com.zup.casaDoCodigo.controller;

import javax.validation.Valid;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casaDoCodigo.entities.Estado;
import br.com.zup.casaDoCodigo.form.EstadoForm;
import br.com.zup.casaDoCodigo.repositories.EstadoRepository;
import br.com.zup.casaDoCodigo.repositories.PaisRepository;

@RestController
@RequestMapping(value = "/estados")
public class EstadoController {
	
	private final EstadoRepository repository;
	private final PaisRepository paisRepository;

	public EstadoController(EstadoRepository repository, PaisRepository paisRepository) {
		super();
		this.repository = repository;
		this.paisRepository = paisRepository;
	}

	@PostMapping
	@Transactional
	public String cadastrarEstados(@RequestBody @Valid EstadoForm form) {
		Estado novoEstado = form.toModel(paisRepository);
			repository.save(novoEstado);
			return novoEstado.toString();
		}
	}
	