package org.huyha.dao;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.huyha.utils.HibernateUtils;


public abstract class HibernateDAO<T> implements Dao<T> {

	private Class<T> domain;

	public HibernateDAO(Class<T> domain) {
		super();
		this.domain = domain;
	}

	/**
	 * Get currentSession
	 */

	public static Session getCurrentSession() {
		return HibernateUtils.getSessionFactory().getCurrentSession();
	}

	/*
	 * get entity by id
	 *
	 */
	public Optional<T> get(int id) {
		return Optional.of(getCurrentSession().get(domain, id));
	}

	/*
	 * get all entity
	 */
	public List<T> getAll() {
		return getCurrentSession().createQuery("from " + domain.getName(), domain).getResultList();
	}

	/*
	 * save an entity
	 */
	public T save(T t) {
		getCurrentSession().save(t);
		return t;
	}

	/*
	 * Update an entity
	 */
	public void update(T t) {
		getCurrentSession().update(t);
	}

	/*
	 * delete an entity
	 */
	public void delete(T t) {
		getCurrentSession().detach(t);
	}

}
