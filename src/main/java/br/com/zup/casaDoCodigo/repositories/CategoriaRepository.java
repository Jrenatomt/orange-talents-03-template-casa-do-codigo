package br.com.zup.casaDoCodigo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.casaDoCodigo.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
