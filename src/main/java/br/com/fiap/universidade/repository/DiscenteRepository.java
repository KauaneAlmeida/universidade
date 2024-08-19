package br.com.fiap.universidade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.universidade.model.Discente;

@Repository
public interface DiscenteRepository extends JpaRepository<Discente, Long>{

}
