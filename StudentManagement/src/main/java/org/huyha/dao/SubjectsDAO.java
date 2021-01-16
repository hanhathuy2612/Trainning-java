package org.huyha.dao;

import org.huyha.entities.Subjects;

public class SubjectsDAO extends HibernateDAO<Subjects> {
	private static SubjectsDAO instance;

	public static SubjectsDAO getInstance() {
		if (instance == null) {
			instance = new SubjectsDAO();
		}
		return instance;
	}
}
