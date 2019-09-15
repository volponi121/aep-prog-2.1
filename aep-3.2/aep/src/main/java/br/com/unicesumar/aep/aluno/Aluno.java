package br.com.unicesumar.aep.aluno;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.unicesumar.aep.conceito.Conceito;

@Entity
@Table(name = "ALUNO")
public class Aluno {
	@Id
	private String id = UUID.randomUUID().toString();
	private String nome;
	private Integer idade;
	private String email;
	@Enumerated(EnumType.STRING)
	private Sexo sexo;
	@ManyToMany
	private List<Conceito> conceitos = new ArrayList<>();


	public String getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public Integer getIdade() {
		return idade;
	}

	public String getNome() {
		return nome;
	}

	public Sexo getSexo() {
		return sexo;
	}
	
	@JsonIgnore
	public List<Conceito> getConceitos() {
		return conceitos;
	}
}
