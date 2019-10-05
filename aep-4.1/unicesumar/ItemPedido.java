package br.unicesumar;

public class ItemPedido {

	private String produto;
	private double quantidade;
	private double valorUnitario;
	private double descontoPercentual;

	public ItemPedido(String produto, double quantidade, double valorUnitario, double descontoPercentual) {
		this.produto = produto;
		this.quantidade = quantidade;
		this.valorUnitario = valorUnitario;
		this.descontoPercentual = descontoPercentual;
	}

	public String getProduto() {
		return produto;
	}

	public double getQuantidade() {
		return quantidade;
	}

	public double getValorUnitario() {
		return valorUnitario;
	}

	public double getDescontoPercentual() {
		return descontoPercentual;
	}

}
