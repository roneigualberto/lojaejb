package br.edu.ifam.loja.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.edu.ifam.loja.model.Item;

@Stateless
public class ItemDAO extends DAO<Item, Long> {

	public ItemDAO() {
		super(Item.class);
	}

	
	@PersistenceContext
	private EntityManager entityManager;

	

	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

}
