package br.com.zup.casaDoCodigo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.casaDoCodigo.entities.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {

}
