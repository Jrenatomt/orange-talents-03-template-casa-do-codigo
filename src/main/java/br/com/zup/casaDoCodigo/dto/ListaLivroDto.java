package br.com.zup.casaDoCodigo.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.zup.casaDoCodigo.entities.Livro;

public class ListaLivroDto {

	private Long id;
	private String titulo;

	public ListaLivroDto(Livro livro) {
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public static List<ListaLivroDto> converter(List<Livro> livros) {
		return livros.stream().map(livro -> new ListaLivroDto(livro)).collect(Collectors.toList());
	}
}