package br.com.zup.casaDoCodigo.form;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.zup.casaDoCodigo.entities.Autor;
import br.com.zup.casaDoCodigo.entities.Categoria;
import br.com.zup.casaDoCodigo.entities.Livro;
import br.com.zup.casaDoCodigo.repositories.AutorRepository;
import br.com.zup.casaDoCodigo.repositories.CategoriaRepository;
import br.com.zup.casaDoCodigo.validation.UniqueValue;

public class LivroForm {
	
	@NotBlank(message = "Preenchimento Obrigatório")
	@UniqueValue(domainClass = Livro.class,fieldName = "titulo")
	private String titulo;
	@Size(max = 500) @NotBlank(message = "Preenchimento Obrigatório") 
	private String resumo;
	@NotBlank(message = "Preenchimento Obrigatório")
	private String sumario;
	@NotNull @Min(20)
	private BigDecimal preco;
	@Min(100)
	private int numeroPaginas;
	@NotBlank(message = "Preenchimento Obrigatório")
	@UniqueValue(domainClass = Livro.class,fieldName = "isbn")
	private String isbn;
	@Future @NotNull
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private LocalDate dataPublicacao;
	
	@NotNull
	private Long categoriaId;
	@NotNull
	private Long autorId;
	
	public LivroForm(@NotBlank String titulo, @Size(max = 500) @NotBlank String resumo,@NotBlank @NotBlank String sumario,
			@NotNull @Min(20) BigDecimal preco, @Min(100) int numeroPaginas, @NotBlank String isbn, @NotNull Long categoriaId, @NotNull Long autorId) {
		super();
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroPaginas = numeroPaginas;
		this.isbn = isbn;
		this.categoriaId = categoriaId;
		this.autorId = autorId;
	}
	//setter necessario para fazer o parse da data
	public void setDataPublicacao(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}
	
	public Livro toModel(AutorRepository autorRepository,
			CategoriaRepository categoriaRepository) {
		
		Autor autor = autorRepository.getOne(autorId);
		Categoria categoria = categoriaRepository.getOne(categoriaId);

		return new Livro(titulo, resumo, sumario, preco, numeroPaginas, isbn,
				dataPublicacao, categoria, autor);
	}
}