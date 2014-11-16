package br.edu.ifam.loja.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class ProdutosVendidos extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@ManyToOne
	private Produto produto;
	
	@Column
	private double valor;
	
	public ProdutosVendidos() {
	}

	public ProdutosVendidos(Produto produto, double valor) {
		super();
		this.produto = produto;
		this.valor = valor;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
	
	
	
	
	

}
