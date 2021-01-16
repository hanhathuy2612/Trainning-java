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
	
	
}
