package br.edu.ifam.loja.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.edu.ifam.loja.model.TipoMovimento;

@ManagedBean
@RequestScoped
public class TipoMovimentoMB {

	public TipoMovimento[] getLista() {

		return TipoMovimento.values();
	}

}
