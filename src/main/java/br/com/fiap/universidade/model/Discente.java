package br.com.fiap.universidade.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "discentes")
public class Discente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String rm;
	@ManyToOne
	@JoinColumn(name = "id_pessoa")
	private Pessoa pessoa;
	@Enumerated(EnumType.STRING)
	private OpcoesStatus status;
	@Enumerated(EnumType.STRING)
	private OpcoesNivel nivel;

	public Discente() {

	}

	public Discente(Long id, String rm, Pessoa pessoa, OpcoesStatus status, OpcoesNivel nivel) {
		super();
		this.id = id;
		this.rm = rm;
		this.pessoa = pessoa;
		this.status = status;
		this.nivel = nivel;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRm() {
		return rm;
	}

	public void setRm(String rm) {
		this.rm = rm;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public OpcoesStatus getStatus() {
		return status;
	}

	public void setStatus(OpcoesStatus status) {
		this.status = status;
	}

	public OpcoesNivel getNivel() {
		return nivel;
	}

	public void setNivel(OpcoesNivel nivel) {
		this.nivel = nivel;
	}

}
