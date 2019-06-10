package repository;

import java.util.List;

import model.BilheteAereo;

public interface BilheteAereoRepository {
	void inserir(BilheteAereo b) throws Exception;

	List<BilheteAereo> obterTodos() throws Exception;

	void alterar(BilheteAereo b) throws Exception;

	void excluir(BilheteAereo bilhete) throws Exception;
}
