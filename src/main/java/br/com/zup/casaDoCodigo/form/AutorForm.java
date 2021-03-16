package br.com.zup.casaDoCodigo.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.zup.casaDoCodigo.entities.Autor;

public class AutorForm {
	
	@NotBlank (message = "o campo nome é obrigatório")
	private String nome;
	@NotBlank@NotBlank (message = "o campo e-mail é obrigatório")
	@Email
	private String email;
	@NotBlank @NotBlank(message = "o campo descrição é obrigatório")
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

	public Autor converterNovoAutor() {
		return new Autor(nome, email, descricao);
	}
}
