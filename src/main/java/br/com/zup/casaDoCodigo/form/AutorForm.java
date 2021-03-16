package br.com.zup.casaDoCodigo.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.zup.casaDoCodigo.entities.Autor;

public class AutorForm {
	
	@NotBlank
	private String nome;
	@NotBlank
	@Email
	private String email;
	@NotBlank 
	@Size (max = 400)
	private String descricao;
	
	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getDescricao() {
		return descricao;
	}

	public Autor novoAutor() {
		return new Autor(nome, email, descricao);
	}
}
