package br.com.zup.casaDoCodigo.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zup.casaDoCodigo.entities.Estado;
import br.com.zup.casaDoCodigo.entities.Pais;
import br.com.zup.casaDoCodigo.repositories.PaisRepository;
import br.com.zup.casaDoCodigo.validation.ExistsId;

public class EstadoForm {
	
	@NotBlank
	private String nome;
	@NotNull
	@ExistsId(domainClass = Pais.class, fieldName = "id")
	private Long paisId;
	
	public EstadoForm(@NotBlank String nome, @NotNull Long paisId) {
		super();
		this.nome = nome;
		this.paisId = paisId;
	}

	public Estado toModel(PaisRepository paisRepository) {
		Pais pais = paisRepository.getOne(paisId);
		return new Estado(nome, pais);
	}
}
