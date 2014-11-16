package br.edu.ifam.loja.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.edu.ifam.loja.model.ProdutosVendidos;
import br.edu.ifam.loja.model.TipoMovimento;

@Stateless
public class ProdutosVendidosDAO extends DAO<ProdutosVendidos, Long> {

	public ProdutosVendidosDAO() {
		super(ProdutosVendidos.class);
	}

	@PostConstruct
	public void init() {
	}

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public List<ProdutosVendidos> gerarRelatorio() {

		return entityManager
				.createQuery(
						"select new ProdutosVendidos(i.produto,sum(i.produto.valor*i.qtde))"
								+ " from Item i where i.movimento.tipo = :venda ) group by i.produto ")
				.setParameter("venda", TipoMovimento.V)

				.getResultList();
	}

	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

}
