package org.huyha.dao;

import java.util.Collection;
import java.util.Optional;

import org.huyha.entities.Student;

public class StudentDAO implements Dao<Student> {

	public Optional<Student> get(int id, Class<Student> type) {
		return HibernateDAO.getInstance().get(id, type);
	}

	public Collection<Student> getAll(Class<Student> type) {
		return HibernateDAO.getInstance().getAll(type);
	}

	public int save(Student t) {
		return HibernateDAO.getInstance().save(t);
	}

	public int update(Student t) {
		return HibernateDAO.getInstance().update(t);
	}

	public int delete(Student t) {
		return HibernateDAO.getInstance().delete(t);
	}

}
