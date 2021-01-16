package org.huyha.service;

import java.util.List;

import org.huyha.dao.StudentDAO;
import org.huyha.entities.Student;

public class Service {
	private static Service instance;

	public static Service getInstance() {
		if (instance == null) {
			instance = new Service();
		}
		return instance;
	}

	public void addListStudent(List<Student> listStudent) {
		
		for (Student st : listStudent) {
			StudentDAO.getInstance().save(st);
		}
	}
}
