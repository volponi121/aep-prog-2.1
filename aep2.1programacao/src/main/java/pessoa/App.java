package pessoa;

import java.util.Set;

public class App {
	public static void main(String[] args) {
		Júridica j1 = new Júridica("Fabio", "123", 12.01);

		Júridica j2 = new Júridica("Hise", "123", 13.1);
		Júridica j3 = new Júridica("Jose", "141", 13.3);
		Júridica j4 = new Júridica("Hise", "123", 13.1);

		j1.adicionarSócio(j2, 13.1);
		j1.adicionarSócio(j3, 13.4);
		j1.adicionarSócio(j4, 13.1);

		j1.removerSócio(j2);
		System.out.println(j1.getCotasSociedade());

	}
}
