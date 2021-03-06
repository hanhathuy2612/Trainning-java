package org.huyha.dao;

import org.huyha.entities.Student;

public class StudentDAO extends HibernateDAO<Student> {
	private static StudentDAO instance;

	private StudentDAO() {
		super(Student.class);
	}
	public static StudentDAO getInstance() {
		if (instance == null) {
			instance = new StudentDAO();
		}
		return instance;
	}
}
