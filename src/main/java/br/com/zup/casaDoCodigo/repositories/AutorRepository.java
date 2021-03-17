package br.com.zup.casaDoCodigo.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.zup.casaDoCodigo.entities.Autor;

public interface AutorRepository extends CrudRepository<Autor, Long> {

	Autor findByEmail(String email);
}
