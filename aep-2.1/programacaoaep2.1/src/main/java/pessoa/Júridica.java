package pessoa;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Júridica extends Pessoa {
	private String cnpj;
	private double capitalSocial;
	private Set<CotaSociedade> cotasSociedade;

	public Set<CotaSociedade> getCotasSociedade() {
		return cotasSociedade;
	}

	Júridica(String nome, String cnpj, double capitalSocial) {
		super(nome);
		if (cnpj != null && !cnpj.isEmpty()) {
			this.cnpj = cnpj;
		}
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
		double percentualAtual = somarPercentualAtual();
		if (percentualAtual + percentualParticipacão > 100.00) {
			throw new RuntimeException("A participação total não pode exceder 100%! Percentual atual: "
					+ percentualAtual + ". Você tentou adicionar mais " + percentualParticipacão);
		}

		this.cotasSociedade.add(cota);

	}

	private double somarPercentualAtual() {
		double percentualAtual = 0.00d;
		for (CotaSociedade cotaSociedade : cotasSociedade) {
			percentualAtual += cotaSociedade.percentualDeParticipação;
		}
		return percentualAtual;
	}

	public void removerSócio(Pessoa sócioRemover) {
		Set<CotaSociedade> removeAux = new HashSet<>();
		for (CotaSociedade cota : cotasSociedade) {
			if (!cota.sócio.equals(sócioRemover)) {
				removeAux.add(cota);
			}
		}	
		this.cotasSociedade = removeAux;
	}

	private class CotaSociedade {
		private Pessoa sócio;
		private double percentualDeParticipação;

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getEnclosingInstance().hashCode();
			long temp;
			temp = Double.doubleToLongBits(percentualDeParticipação);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			result = prime * result + ((sócio == null) ? 0 : sócio.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			CotaSociedade other = (CotaSociedade) obj;
			if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
				return false;
			if (Double.doubleToLongBits(percentualDeParticipação) != Double
					.doubleToLongBits(other.percentualDeParticipação))
				return false;
			if (sócio == null) {
				if (other.sócio != null)
					return false;
			} else if (!sócio.equals(other.sócio))
				return false;
			return true;
		}

		private Júridica getEnclosingInstance() {
			return Júridica.this;
		}

	}

	public void listarSocios() {
		for (CotaSociedade auxiliar : cotasSociedade) {
			System.out.println("Nome: " + auxiliar.sócio.getNome());
			System.out.println("Percentual: " + auxiliar.percentualDeParticipação);
		}
	}

}
