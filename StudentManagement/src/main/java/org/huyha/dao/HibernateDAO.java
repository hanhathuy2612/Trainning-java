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
import org.huyha.utils.HibernateUtils;

public class HibernateDAO<T> implements Dao<T> {
	private static HibernateDAO instance;

	public static HibernateDAO getInstance() {
		if (instance == null) {
			instance = new HibernateDAO();
		}
		return instance;
	}

	public Optional<T> get(int id, Class<T> type) {
		SessionFactory factory = HibernateUtils.getSessionFactory();

		Session session = factory.getCurrentSession();

		T classes = null;

		try {
			session.getTransaction().begin();

			classes = session.get(type, id);

			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		return Optional.of(classes);
	}

	public Collection<T> getAll(Class<T> type) {
		SessionFactory factory = HibernateUtils.getSessionFactory();

		Session session = factory.getCurrentSession();

		List<T> classes = new ArrayList<T>();

		try {
			session.getTransaction().begin();

			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<T> cq = cb.createQuery(type);
			cq.from(type);
			classes = session.createQuery(cq).getResultList();

			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		return classes;
	}

	public int save(T t) {
		int kq = 0;

		SessionFactory factory = HibernateUtils.getSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			session.getTransaction().begin();

			session.save(t);

			kq = 1;

			session.flush();

			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		return kq;
	}

	public int update(T t) {
		int kq = 0;

		SessionFactory factory = HibernateUtils.getSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			session.getTransaction().begin();

			session.update(t);

			kq = 1;

			session.flush();

			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		return kq;
	}

	public int delete(T t) {
		int kq = 0;

		SessionFactory factory = HibernateUtils.getSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			session.getTransaction().begin();

			session.delete(t);

			kq = 1;

			session.flush();

			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		return kq;
	}

}
