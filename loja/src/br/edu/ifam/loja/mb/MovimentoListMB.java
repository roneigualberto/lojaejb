package br.edu.ifam.loja.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.edu.ifam.loja.dao.MovimentoDAO;
import br.edu.ifam.loja.model.Movimento;

@ManagedBean
@ViewScoped
public class MovimentoListMB {

	private List<Movimento> movimentos;
	
	@EJB
	private MovimentoDAO dao;

	@PostConstruct
	public void init() {
		movimentos = dao.lista();
	}

	public List<Movimento> getMovimentos() {
		return movimentos;
	}

	

}
