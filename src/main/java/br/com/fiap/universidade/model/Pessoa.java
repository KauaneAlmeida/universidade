package br.com.fiap.universidade.model;


import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "pessoas")
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Size(min = 4, max = 255, message = "O nome da nova pessoa deve ter, ao menos, 4 caracteres e, no máximo, 255")
	@NotEmpty(message = "O nome da pessoa não pode estar em branco")
	private String nome;
	@CPF
	private String cpf;
	@Enumerated(EnumType.STRING)
	private OpcoesPaises pais_origem;
	@Positive(message = "A idade deve ser um valor positivo")
	private Integer idade;

	public Pessoa() {

	}

	public Pessoa(Long id, String nome, String cpf, OpcoesPaises pais_origem, Integer idade) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.pais_origem = pais_origem;
		this.idade = idade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public OpcoesPaises getPais_origem() {
		return pais_origem;
	}

	public void setPais_origem(OpcoesPaises pais_origem) {
		this.pais_origem = pais_origem;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

}
