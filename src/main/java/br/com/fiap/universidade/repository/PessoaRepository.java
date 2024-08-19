package br.com.fiap.universidade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.universidade.model.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa,Long>{

}
