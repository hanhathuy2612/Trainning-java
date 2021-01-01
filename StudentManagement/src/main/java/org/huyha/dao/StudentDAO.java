package org.huyha.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

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
	 * get a Student
	 */
	public Optional<Student> get(int id) {
		SessionFactory factory = HibernateUtils.getSessionFactory();

		Session session = factory.getCurrentSession();

		Student st = null;

		try {
			session.getTransaction().begin();

			String sql = "Select e from " + Student.class.getName() + " e " + " where e.id = :Id ";

			Query<Student> query = session.createQuery(sql);

			query.setParameter("Id", id);

			st = query.getSingleResult();

			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		return Optional.of(st);
	}

	/*
	 * get all Student
	 */
	public Collection<Student> getAll() {
		List<Student> students = new ArrayList<Student>();

		SessionFactory factory = HibernateUtils.getSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.getTransaction().begin();

			String sql = "Select e from " + Student.class.getName() + " e ";

			Query<Student> query = session.createQuery(sql);

			students = query.getResultList();

			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return students;
	}

	/*
	 * save a student
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
	 * update a student
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
	 * delete a student
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
