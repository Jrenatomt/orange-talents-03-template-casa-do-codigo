package br.com.zup.casaDoCodigo.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.com.zup.casaDoCodigo.entities.Categoria;

public interface CategoriaRepository extends CrudRepository<Categoria, Long> {

	Optional<Categoria> findByNome(String nome);

}
