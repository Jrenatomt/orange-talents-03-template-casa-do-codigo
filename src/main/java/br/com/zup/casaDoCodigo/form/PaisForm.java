package br.com.zup.casaDoCodigo.form;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonCreator;

import br.com.zup.casaDoCodigo.entities.Pais;
import br.com.zup.casaDoCodigo.validation.UniqueValue;

public class PaisForm {
	
	@NotBlank 
	@UniqueValue(domainClass = Pais.class, fieldName = "nome")
	private String nome;

	public PaisForm() {
	}
     
	@JsonCreator
	public PaisForm(@NotBlank String nome) {
		this.nome = nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Pais toModel() {
		return new Pais(nome);
	}
}
