package org.huyha.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.huyha.entities.Student;
import org.huyha.exception.StudentNotAuthorizedException;
import org.huyha.utils.HibernateUtils;

public class HibernateDAO<T> implements Dao<T> {
	private static HibernateDAO instance;

	/**
	 * Singlethon structure
	 * 
	 * @return instance
	 */
	public static HibernateDAO getInstance() {
		if (instance == null) {
			instance = new HibernateDAO();
		}
		return instance;
	}

	/**
	 * Get currentSession
	 */

	public Session getCurrentSession() {
		return HibernateUtils.getSessionFactory().getCurrentSession();
	}

	/*
	 * get entity by id
	 *
	 */
	public Optional<T> get(int id, Class<T> type) {
		return Optional.of(getCurrentSession().get(type, id));
	}

	/*
	 * get all entity
	 */
	public Collection<T> getAll(Class<T> type) {

//		Session session = getCurrentSession();
//
//		List<T> classes = new ArrayList<T>();
//
//		CriteriaBuilder cb = session.getCriteriaBuilder();
//		CriteriaQuery<T> cq = cb.createQuery(type);
//		cq.from(type);
//		classes = session.createQuery(cq).getResultList();
		return getCurrentSession().createQuery("from " + type.getName()).list();
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
