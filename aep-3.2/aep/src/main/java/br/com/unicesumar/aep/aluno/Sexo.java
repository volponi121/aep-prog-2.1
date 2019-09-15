package br.com.unicesumar.aep.aluno;

public enum Sexo {
	HOMEM("Homen"), MULHER("Mulher"), OUTRO("Outro");

	private String tipo;

	Sexo(String tipo) {
		this.tipo = tipo;
	}
}
