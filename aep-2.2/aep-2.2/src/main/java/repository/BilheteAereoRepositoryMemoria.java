package repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import model.BilheteAereo;

public class BilheteAereoRepositoryMemoria implements BilheteAereoRepository {
	
	private List<BilheteAereo> bilhetes = new ArrayList<>();
	
	
	public void inserir(BilheteAereo c) {
		this.bilhetes.add(c);
	}

	public List<BilheteAereo> obterTodos() {
		return Collections.unmodifiableList(new ArrayList<>(bilhetes));
	}

	public void alterar(BilheteAereo b) {
		this.excluir(b);
		this.inserir(b);
	}

	public void excluir(BilheteAereo bilhete) {
		this.bilhetes = bilhetes.stream().filter(c -> c.getId() != bilhete.getId()).collect(Collectors.toList());

	}

	public List<BilheteAereo> getBilhetes() {
		return bilhetes;
	}


}
