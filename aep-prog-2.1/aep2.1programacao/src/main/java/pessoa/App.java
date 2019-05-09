package pessoa;

public class App {
	public static void main(String[] args) {
		Júridica j1 = new Júridica("Fabio", "123", 12.01);
		Júridica j2 = new Júridica("Hise", "123", 13.1);
		
		
		j1.adicionarSócio(j1, 12.1);
		j1.adicionarSócio(j1, 12.1);
		j1.adicionarSócio(j1, 12.1);
		j1.removerSócio(j1);
		
		System.out.println(j1.getCotasSociedade());
	
	
	}
}

