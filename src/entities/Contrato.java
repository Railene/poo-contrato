package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contrato {
	private Integer numero;
	private Date data;
	private Double valorTotal;
	
	private List<Prestacao> parcelas = new ArrayList<>();
	
	public Contrato(Integer numero, Date data, Double valorTotal) {
		this.numero = numero;
		this.data = data;
		this.valorTotal = valorTotal;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public List<Prestacao> getParcela() {
		return parcelas;
	}

	public void addPrestacao(Prestacao prestacao) {
		parcelas.add(prestacao);
	}

	public void removePrestacao(Prestacao prestacao) {
		parcelas.remove(prestacao);
	}
}
