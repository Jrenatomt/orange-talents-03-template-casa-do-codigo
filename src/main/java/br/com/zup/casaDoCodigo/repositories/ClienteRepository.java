package br.com.zup.casaDoCodigo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.casaDoCodigo.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
