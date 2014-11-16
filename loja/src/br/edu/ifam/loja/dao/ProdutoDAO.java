package br.edu.ifam.loja.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.edu.ifam.loja.model.Produto;

@Stateless
public class ProdutoDAO extends DAO<Produto, Long> {

	public ProdutoDAO() {
		super(Produto.class);
	}	

	

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

}
