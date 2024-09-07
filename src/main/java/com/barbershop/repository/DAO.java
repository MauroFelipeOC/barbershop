package com.barbershop.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public abstract class DAO<E> {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Class<E> entity;
	
	static {
		try {
			emf = Persistence.createEntityManagerFactory("barber");
		} catch (Exception e) {
			System.out.println("An error ocurred while attempt to create entity manager");
		}
	}
	
	public DAO() {
		this(null);
	}
	
	public DAO(Class<E> entity) {
		this.entity = entity;
		em = emf.createEntityManager();
	}
	
	public DAO<E> openTransaction() {
		em.getTransaction().begin();
		return this;
	}
	
	public DAO<E> closeTransaction() {
		em.getTransaction().commit();
		return this;
	}
	
	public DAO<E> add(E entity) {
		if(entity == null) {
			throw new UnsupportedOperationException("Classe nula.");
		}
		
		em.persist(entity);
		return this;
	}
	
	public DAO<E> addAtomic(E entity) {
		return this.openTransaction().add(entity).closeTransaction();
	}
	
	public E getById(Object id) {
		return em.find(entity, id);
	}
	
	public List<E> getAll(int qtde, int deslocamento) {
		if(entity == null) {
			throw new UnsupportedOperationException("Classe nula.");
		}
		
		String jpql = "select e from " + entity.getName() + " e";
		TypedQuery<E> query = em.createQuery(jpql, entity)
				.setMaxResults(qtde)
				.setFirstResult(deslocamento);
		
		return query.getResultList();
	}
	
	public void close() {
		this.em.close();
	}

}