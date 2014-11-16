package br.edu.ifam.loja.schedule;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.TimerService;

import br.edu.ifam.loja.dao.ProdutosVendidosDAO;
import br.edu.ifam.loja.model.ProdutosVendidos;

@Singleton
@Startup
public class ProdutosVendidosSchedule {

	@Resource
	private TimerService service;

	@EJB
	private ProdutosVendidosDAO dao;

	@Schedule(hour = "*", minute = "*", second = "1", persistent = false)
	public void salvarProdutosVendidos() {

		List<ProdutosVendidos> produtosVendidos = dao.gerarRelatorio();

		for (ProdutosVendidos produtoVendido : produtosVendidos) {
			dao.salva(produtoVendido);
		}

	}

}
