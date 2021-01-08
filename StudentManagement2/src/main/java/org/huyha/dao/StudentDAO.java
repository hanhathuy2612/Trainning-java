package org.huyha.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.huyha.entities.Student;
import org.huyha.utils.HibernateUtils;

public class StudentDAO implements Dao<Student> {
	private static StudentDAO studentDAO;

	public static StudentDAO getStudentDAO() {
		if (studentDAO == null) {
			studentDAO = new StudentDAO();
		}
		return studentDAO;
	}

	/*
	 * get student
	 */
	public Optional<Student> get(int id) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();

		Student st = null;

		try {
			session.getTransaction().begin();

			st = (Student) session.get(Student.class, id);

			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return Optional.of(st);

	}

	/*
	 * get all student
	 */
	public Collection<Student> getAll() {
//		List<Student> students = new ArrayList<Student>();
//
//		SessionFactory factory = HibernateUtils.getSessionFactory();
//
//		Session session = factory.getCurrentSession();
//		try {
//
//			session.getTransaction().begin();
//
//			String sql = "Select e from " + Student.class.getName() + " e ";
//
//			Query<Student> query = session.createQuery(sql);
//
//			students = query.getResultList();
//
//			session.getTransaction().commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//			session.getTransaction().rollback();
//		}
//		return students;
		List<Student> students = new ArrayList<Student>();

		SessionFactory factory = HibernateUtils.getSessionFactory();

		Session session = factory.getCurrentSession();
		try {
			session.getTransaction().begin();

			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<Student> cq = cb.createQuery(Student.class);
			Root<Student> rootEntity = cq.from(Student.class);
			cq.select(rootEntity);
			Query<Student> query = session.createQuery(cq);
			students = query.getResultList();

			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return students;
	}

	/*
	 * add student
	 */
	public int save(Student t) {
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

	/*
	 * Update student
	 */
	public int update(Student t) {
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

	/*
	 * delete student
	 */
	public int delete(Student t) {
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
