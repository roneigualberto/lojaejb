package br.edu.ifam.loja.model;

public enum TipoMovimento {

	C("Compra"), V("Venda");

	private String descricao;

	private TipoMovimento(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
