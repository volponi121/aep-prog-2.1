package br.com.unicesumar.aep.avaliacao;

public enum NomeAvaliacao {
	PROGRAMACAO("Programação"),
	BANCODEDADOS("Banco de Dados"),
	PESQUISAOPERACIONAL("Pesquisa Operacional"),
	ENGENHARIADESOFTWARE("Engenharia de Software"),
	SISTEMASOPERACIONAIS("Sistemas Operacionais");
		
	private String nome;

	private NomeAvaliacao(String nome) {
		this.nome = nome;
	}
	
}
