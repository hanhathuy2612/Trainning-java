package org.huyha.service;

import java.util.Collection;
import java.util.Optional;

import org.huyha.dao.HibernateDAO;
import org.huyha.entities.Student;

public class StudentService implements Serviece<Student> {
	private static StudentService instance;

	public static StudentService getInstance() {
		if (instance == null) {
			instance = new StudentService();
		}
		return instance;
	}

	public Optional<Student> get(int id, Class<Student> type) {
		return HibernateDAO.getInstance().get(id, type);
	}

	public Collection<Student> getAll(Class<Student> type) {
		return HibernateDAO.getInstance().getAll(type);
	}

	public boolean save(Student t) {
		if (HibernateDAO.getInstance().save(t) == 1) {
			return true;
		}
		return false;
	}

	public boolean update(Student t) {
		if (HibernateDAO.getInstance().update(t) == 1) {
			return true;
		}
		return false;
	}

	public boolean delete(Student t) {
		if (HibernateDAO.getInstance().delete(t) == 1) {
			return true;
		}
		return false;
	}

}
