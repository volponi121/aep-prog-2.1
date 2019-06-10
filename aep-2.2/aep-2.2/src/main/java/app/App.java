package app;

import java.util.Date;

import model.BilheteAereo;
import repository.BilheteAereoRepository;
import repository.BilheteAereoRepositoryJDBC;
import repository.BilheteAereoRepositoryMemoria;

public class App {
	public static void main(String[] args) throws Exception {
		BilheteAereo bilhete1 = new BilheteAereo(1, 1, "PR", "BA", new Date());
		BilheteAereo bilhete2 = new BilheteAereo(2, 2, "SP", "PR", new Date());
		BilheteAereo bilhete3 = new BilheteAereo(3, 3, "BA", "SP", new Date());

		BilheteAereoRepository bilheteMemoria = new BilheteAereoRepositoryMemoria();
		BilheteAereoRepository bilheteJDBC = new BilheteAereoRepositoryJDBC();

		bilheteMemoria.inserir(bilhete1);
		bilheteMemoria.inserir(bilhete2);
		bilheteMemoria.inserir(bilhete3);

		bilheteMemoria.alterar(bilhete1);

		bilheteMemoria.excluir(bilhete1);
		
		bilheteMemoria.obterTodos();

		bilheteJDBC.inserir(bilhete1);
		bilheteJDBC.inserir(bilhete2);
		bilheteJDBC.inserir(bilhete3);

		bilheteJDBC.alterar(bilhete1);

		bilheteJDBC.excluir(bilhete1);
		
		bilheteJDBC.obterTodos();

	}
}
