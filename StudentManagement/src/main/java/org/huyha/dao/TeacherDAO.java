package org.huyha.dao;

import org.huyha.entities.Teacher;

public class TeacherDAO extends HibernateDAO<Teacher> {
	private static TeacherDAO instance;

	public static TeacherDAO getInstance() {
		if (instance == null) {
			instance = new TeacherDAO();
		}
		return instance;
	}
}
