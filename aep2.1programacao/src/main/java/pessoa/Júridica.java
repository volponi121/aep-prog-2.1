package pessoa;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Júridica extends Pessoa {
	private String cnpj;
	private double capitalSocial;
	private Set<CotaSociedade> cotasSociedade = new HashSet<CotaSociedade>();

	Júridica(String nome, String cnpj, double capitalSocial) {
		super(nome);
		this.cnpj = cnpj;
		this.capitalSocial = capitalSocial;
	}

	Júridica(UUID id, String nome, String cnpj, double capitalSocial) {
		super(id, nome);
		this.cnpj = cnpj;
		this.capitalSocial = capitalSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public Set<CotaSociedade> getCotasSociedade() {
		return cotasSociedade;
	}

	public double getCapitalSocial() {
		return capitalSocial;
	}

	public void adicionarSócio(Júridica sócio, double percentualDeParticipação) {
		CotaSociedade cotaSociedade = new CotaSociedade(sócio, percentualDeParticipação);
		cotasSociedade.add(cotaSociedade);
	}

	public void removerSócio(Júridica sócio) {
		for (CotaSociedade cotas : cotasSociedade) {
			if (cotas.sócio == sócio) {
				cotasSociedade.remove(cotas);
			}
		}
	}

	private class CotaSociedade {
		private Júridica sócio;
		private double percentualDeParticipação;

		CotaSociedade(Júridica sócio, double percentualDeParticipação) {
			this.sócio = sócio;
			this.percentualDeParticipação = percentualDeParticipação;
		}
	}
}
