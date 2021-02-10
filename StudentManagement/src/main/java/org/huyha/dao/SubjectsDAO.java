package org.huyha.dao;

import org.huyha.entities.Subjects;

public class SubjectsDAO extends HibernateDAO<Subjects> {
	private static SubjectsDAO instance;

	private SubjectsDAO() {
		super(Subjects.class);
	}

	public static SubjectsDAO getInstance() {
		if (instance == null) {
			instance = new SubjectsDAO();
		}
		return instance;
	}
}
