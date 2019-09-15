package br.com.unicesumar.aep.conceito;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.unicesumar.aep.aluno.Aluno;
import br.com.unicesumar.aep.avaliacao.Avaliacao;
import br.com.unicesumar.aep.nota.Nota;

@Entity
@Table(name = "CONCEITO")
public class Conceito {
	@Id
	private String id = UUID.randomUUID().toString();
	@OneToOne(cascade = CascadeType.ALL)
	private Nota nota;
	@ManyToMany(mappedBy = "conceitos")
	private Set<Avaliacao> avaliacoes = new HashSet<>();
	@ManyToMany(mappedBy = "conceitos")
	private Set<Aluno> alunos = new HashSet<>();

	public Conceito(String id, Nota nota, Set<Avaliacao> avaliacoes, Set<Aluno> alunos) {
		this.id = id;
		this.nota= nota;
		this.avaliacoes = avaliacoes;
		this.alunos = alunos;
	}

	public String getId() {
		return id;
	}

	public Set<Aluno> getAlunos() {
		return alunos;
	}

	public Set<Avaliacao> getAvaliacoes() {
		return avaliacoes;
	}
}
