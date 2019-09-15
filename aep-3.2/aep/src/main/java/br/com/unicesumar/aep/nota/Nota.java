package br.com.unicesumar.aep.nota;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "NOTA")
public class Nota {
	@Id
	private String id = UUID.randomUUID().toString();
	private float valorNota;

	public Nota(Integer valorNota) {
		if (valorNota < 0.0 || valorNota > 10.0) {
			throw new RuntimeException("Informe uma nota entre 0 e 100.");
		}
		this.valorNota = valorNota;
	}

	public String getId() {
		return id;
	}

	public float getValorNota() {
		return valorNota;
	}
}
