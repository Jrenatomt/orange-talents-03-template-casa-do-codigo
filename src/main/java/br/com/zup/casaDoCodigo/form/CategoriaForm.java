package br.com.zup.casaDoCodigo.form;

import javax.validation.constraints.NotBlank;

import br.com.zup.casaDoCodigo.entities.Categoria;

public class CategoriaForm {
	
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
