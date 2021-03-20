package br.com.zup.casaDoCodigo.controller;

import javax.validation.Valid;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casaDoCodigo.entities.Cliente;
import br.com.zup.casaDoCodigo.form.ClienteForm;
import br.com.zup.casaDoCodigo.repositories.ClienteRepository;
import br.com.zup.casaDoCodigo.repositories.EstadoRepository;
import br.com.zup.casaDoCodigo.repositories.PaisRepository;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {
	
	private final ClienteRepository repository;
	private final PaisRepository paisRepository;
	private final EstadoRepository estadoRepository;
	
	public ClienteController(ClienteRepository repository, PaisRepository paisRepository,
			EstadoRepository estadoRepository) {
		super();
		this.repository = repository;
		this.paisRepository = paisRepository;
		this.estadoRepository = estadoRepository;
	}

	@PostMapping
	@Transactional
	public Long cadastrarCliente(@RequestBody @Valid ClienteForm form) {
		Cliente novoCliente = form.toModel(paisRepository, estadoRepository);
		repository.save(novoCliente);
		return novoCliente.getId();
	}
}