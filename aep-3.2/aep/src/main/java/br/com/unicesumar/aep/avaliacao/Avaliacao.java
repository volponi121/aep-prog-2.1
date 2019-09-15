package br.com.unicesumar.aep.avaliacao;

import java.util.HashSet;
import java.util.Set;
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
@Table(name = "AVALIACAO")
public class Avaliacao {
	@Id
	private String id = UUID.randomUUID().toString();
	@Enumerated(EnumType.STRING)
	private NomeAvaliacao nomeAvaliacao;
	@ManyToMany
	private Set<Conceito> conceitos = new HashSet<Conceito>();

	public String getId() {
		return id;
	}

	public NomeAvaliacao getNomeAvaliacao() {
		return nomeAvaliacao;
	}
	
	@JsonIgnore
	public Set<Conceito> getConceitos() {
		return conceitos;
	}

}
