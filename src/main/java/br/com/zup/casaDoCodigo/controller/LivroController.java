package br.com.zup.casaDoCodigo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casaDoCodigo.entities.Livro;
import br.com.zup.casaDoCodigo.form.ListLivroForm;
import br.com.zup.casaDoCodigo.form.LivroForm;
import br.com.zup.casaDoCodigo.repositories.AutorRepository;
import br.com.zup.casaDoCodigo.repositories.CategoriaRepository;
import br.com.zup.casaDoCodigo.repositories.LivroRepository;

@RestController
@RequestMapping(value = "/livros")
public class LivroController {
	
	private final LivroRepository repository;
	private final AutorRepository autorRepository;
	private final CategoriaRepository categoriaRepository;
	
	public LivroController(LivroRepository repository, AutorRepository autorRepository,
			CategoriaRepository categoriaRepository) {
		this.repository = repository;
		this.autorRepository = autorRepository;
		this.categoriaRepository = categoriaRepository;
	}

	@PostMapping
	public void cadastarLivro(@RequestBody @Valid LivroForm form) {
		Livro novoLivro = form.toModel(autorRepository, categoriaRepository);
		repository.save(novoLivro);
	}
	
	@GetMapping
	public List<ListLivroForm> listarlivros(){
		List<Livro> livros = repository.findAll();
		return ListLivroForm.converter(livros);
	}
}
