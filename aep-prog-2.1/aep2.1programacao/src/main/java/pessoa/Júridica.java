package pessoa;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Júridica extends Pessoa {
	private String cnpj;
	private double capitalSocial;
	private HashSet<CotaSociedade> cotasSociedade;

	public Set<CotaSociedade> getCotasSociedade() {
		return cotasSociedade;
	}

	Júridica(String nome, String cnpj, double capitalSocial) {
		super(nome);
		this.cnpj = cnpj;
		this.capitalSocial = capitalSocial;
		cotasSociedade = new HashSet<>();
	}

	Júridica(UUID id, String nome, String cnpj, double capitalSocial) {
		super(id, nome);
		this.cnpj = cnpj;
		this.capitalSocial = capitalSocial;
		cotasSociedade = new HashSet<>();
	}

	public String getCnpj() {
		return cnpj;
	}

	public double getCapitalSocial() {
		return capitalSocial;
	}

	public void adicionarSócio(Pessoa sócio, double percentualParticipacão) {
		CotaSociedade cota = new CotaSociedade();
		cota.sócio = sócio;
		cota.percentualDeParticipação = percentualParticipacão;
		cotasSociedade.add(cota);
	}

	public void removerSócio(Pessoa sócio) {
		cotasSociedade.remove(sócio);
	}

	private class CotaSociedade {
		private Pessoa sócio;
		private double percentualDeParticipação;

		@Override
		public String toString() {
			return sócio + " + " + percentualDeParticipação;
		}
	}
}
