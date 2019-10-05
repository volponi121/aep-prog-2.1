package br.unicesumar;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

	private int numero;
	private List<ItemPedido> itens = new ArrayList<>();
	
	public Pedido(int numero) {
		this.numero = numero;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public void adicionarItem(String produto, double quantidade, double valorUnitario, double descontoPercentual) {
		ItemPedido itemPedido = new ItemPedido(produto,quantidade,valorUnitario,descontoPercentual);
		itens.add(itemPedido);
	}

	public double getValorTotal() {
		double valorTotal = 0;
		for(ItemPedido item : itens) {
			valorTotal += ((item.getQuantidade()*item.getValorUnitario()) -((item.getQuantidade()*item.getValorUnitario()))* item.getDescontoPercentual()/100 );
		}
		return valorTotal;
	}

	public int contarItens() {
		return itens.size();
	}

	public ItemPedido getItem(String itemPedido) {
		for(ItemPedido item : itens) {
			if(item.getProduto().equals(itemPedido)) {
				return item;
			}
		}
		return null;
	}

}
