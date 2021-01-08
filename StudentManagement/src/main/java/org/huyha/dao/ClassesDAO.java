package org.huyha.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.huyha.entities.Classes;
import org.huyha.entities.Student;
import org.huyha.utils.HibernateUtils;

public class ClassesDAO implements Dao<Classes> {
	private static ClassesDAO classesDAO;

	public static ClassesDAO getClassesDAO() {
		if (classesDAO == null) {
			classesDAO = new ClassesDAO();
		}
		return classesDAO;
	}

	/*
	 * get a Classes
	 */
	public Optional<Classes> get(int id) {
		SessionFactory factory = HibernateUtils.getSessionFactory();

		Session session = factory.getCurrentSession();

		Classes classes = new Classes();

		try {
			session.getTransaction().begin();

			classes = (Classes) session.get(Classes.class, id);

			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		return Optional.of(classes);
	}

	/*
	 * get all Classes
	 */
	public Collection<Classes> getAll() {
		SessionFactory factory = HibernateUtils.getSessionFactory();

		Session session = factory.getCurrentSession();

		List<Classes> classes = new ArrayList<Classes>();

		try {
			session.getTransaction().begin();

			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<Classes> cq = cb.createQuery(Classes.class);
			cq.from(Classes.class);
			classes = session.createQuery(cq).getResultList();

			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		return classes;
	}

	/*
	 * save Classes
	 */
	public int save(Classes t) {
		int kq = 0;

		SessionFactory factory = HibernateUtils.getSessionFactory();

		Session session = factory.getCurrentSession();

		List<Classes> classes = new ArrayList<Classes>();

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

	/*
	 * update Classes
	 */
	public int update(Classes t) {
		int kq = 0;

		SessionFactory factory = HibernateUtils.getSessionFactory();

		Session session = factory.getCurrentSession();

		List<Classes> classes = new ArrayList<Classes>();

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

	/*
	 * delete Classes
	 */
	public int delete(Classes t) {
		int kq = 0;

		SessionFactory factory = HibernateUtils.getSessionFactory();

		Session session = factory.getCurrentSession();

		List<Classes> classes = new ArrayList<Classes>();

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
