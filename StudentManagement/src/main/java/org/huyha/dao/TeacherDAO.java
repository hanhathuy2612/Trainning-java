package org.huyha.dao;

import org.huyha.entities.Teacher;

public class TeacherDAO extends HibernateDAO<Teacher> {
	private static TeacherDAO instance;

	private TeacherDAO() {
		super(Teacher.class);
	}

	public static TeacherDAO getInstance() {
		if (instance == null) {
			instance = new TeacherDAO();
		}
		return instance;
	}
}
