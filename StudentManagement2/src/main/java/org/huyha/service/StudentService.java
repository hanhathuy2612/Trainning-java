package org.huyha.service;

import java.util.Collection;
import java.util.Optional;

import org.huyha.dao.StudentDAO;
import org.huyha.entities.Student;

public class StudentService implements Serviece<Student> {
	private static StudentService service;

	public static StudentService getService() {
		if (service == null) {
			service = new StudentService();
		}
		return service;
	}

	public Optional<Student> get(int id) {
		return StudentDAO.getStudentDAO().get(id);
	}

	public Collection<Student> getAll() {
		return StudentDAO.getStudentDAO().getAll();
	}

	public boolean save(Student t) {
		if (StudentDAO.getStudentDAO().save(t) != 0) {
			return true;
		}
		return false;
	}

	public boolean update(Student t) {
		if (StudentDAO.getStudentDAO().update(t) != 0) {
			return true;
		}
		return false;
	}

	public boolean delete(Student t) {
		if (StudentDAO.getStudentDAO().delete(t) != 0) {
			return true;
		}
		return false;
	}

}
