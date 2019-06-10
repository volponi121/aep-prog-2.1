package pessoa;

public class App {
	public static void main(String[] args) {
		
		Júridica uniCesumar = new Júridica("UniCesumar Centro Universitário Cesumar Ltda.", "01.004.137/0001-55",
				500_000d);

	
		uniCesumar.adicionarSócio(uniCesumar, 0.25d);
		uniCesumar.adicionarSócio(uniCesumar, 0.30d);
		// Ainda permite adicionar mesma pessoa com valores diferentes...
		System.out.println(uniCesumar.getCotasSociedade());
	}
}
