package br.com.zup.casaDoCodigo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.casaDoCodigo.entities.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{

}
