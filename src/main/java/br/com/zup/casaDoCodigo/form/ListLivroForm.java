package br.com.zup.casaDoCodigo.form;

import java.util.List;
import java.util.stream.Collectors;

import br.com.zup.casaDoCodigo.entities.Livro;

public class ListLivroForm {
	
	private Long id;
	private String titulo;
	
	public ListLivroForm(Livro livro) {
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
	}
	
	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public static List<ListLivroForm> converter(List<Livro> livros) {
		return livros.stream().map( livro -> new ListLivroForm(livro)).collect(Collectors.toList());
	}
}
