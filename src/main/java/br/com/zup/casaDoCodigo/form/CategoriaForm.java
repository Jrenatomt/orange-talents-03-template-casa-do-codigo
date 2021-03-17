package br.com.zup.casaDoCodigo.form;

import javax.validation.constraints.NotBlank;

import br.com.zup.casaDoCodigo.entities.Categoria;
import br.com.zup.casaDoCodigo.validation.UniqueValue;

public class CategoriaForm {
	
	@UniqueValue(domainClass = Categoria.class, fieldName = "nome")
	@NotBlank(message = "Preenchimento Obrigatório")
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Categoria toModel() {
		return new Categoria(nome);
	}
}