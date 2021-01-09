package org.huyha.service;

import java.util.Collection;
import java.util.Optional;

import org.huyha.dao.HibernateDAO;
import org.huyha.dao.StudentDAO;
import org.huyha.entities.Student;

public class StudentService {
	private static StudentService instance;

	public static StudentService getInstance() {
		if (instance == null) {
			instance = new StudentService();
		}
		return instance;
	}

	public Optional<Student> get(int id, Class<Student> type) {
		return StudentDAO.getInstance().get(id, type);
	}

	public Collection<Student> getAll(Class<Student> type) {
		return StudentDAO.getInstance().getAll(type);
	}

	public boolean save(Student t) {
		if (StudentDAO.getInstance().save(t) == 1) {
			return true;
		}
		return false;
	}

	public boolean update(Student t) {
		if (StudentDAO.getInstance().update(t) == 1) {
			return true;
		}
		return false;
	}

	public boolean delete(Student t) {
		if (StudentDAO.getInstance().delete(t) == 1) {
			return true;
		}
		return false;
	}

}
