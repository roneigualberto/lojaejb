package br.edu.ifam.loja.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.edu.ifam.loja.model.Movimento;

@Stateless
public class MovimentoDAO extends DAO<Movimento, Long> {

	@PersistenceContext
	private EntityManager entityManager;
	
	

	public MovimentoDAO() {
		super(Movimento.class);	
	}
	public Movimento salvaOuAtualiza(Movimento movimento) {

		return movimento.getId() == null ? salva(movimento)
				: atualiza(movimento);
	}


	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

}
