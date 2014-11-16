package br.edu.ifam.loja.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

public abstract class DAO<T, IDType extends Serializable> {

	private Class<T> entityClass;

	
	public abstract EntityManager getEntityManager();

	public DAO(Class<T> entiClass) {
		this.entityClass = entiClass;
	}

	public T salva(T obj) {
		getEntityManager().persist(obj);

		return obj;
	}

	public T atualiza(T obj) {
		return getEntityManager().merge(obj);

	}

	public void remove(T obj) {
		getEntityManager().remove(getEntityManager().merge(obj));
	}

	public T consulta(IDType id) {
		return getEntityManager().find(entityClass, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> lista() {
		return getEntityManager().createQuery("from " + entityClass.getSimpleName()).getResultList();
	}

	

}
