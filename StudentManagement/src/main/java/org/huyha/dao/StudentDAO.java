package org.huyha.dao;

import java.util.Collection;
import java.util.Optional;

import org.huyha.entities.Student;

public class StudentDAO extends HibernateDAO<Student> {
	private static StudentDAO instance;

	public static StudentDAO getInstance() {
		if (instance == null) {
			instance = new StudentDAO();
		}
		return instance;
	}
}
