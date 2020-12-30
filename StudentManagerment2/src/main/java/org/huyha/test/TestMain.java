package org.huyha.test;

import org.huyha.dao.StudentDAO;
import org.huyha.entities.Student;

public class TestMain {
	public static void main(String[] args) {
		for (Student item : StudentDAO.getInstances().getListStudent()) {
			System.out.println(item.toString());
		}
	}
}
