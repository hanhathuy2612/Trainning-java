package org.huyha.dao;

import org.huyha.entities.Classes;

public class ClassesDAO extends HibernateDAO<Classes> {

	private static ClassesDAO instance;

	private ClassesDAO() {
		super(Classes.class);
	}

	public static ClassesDAO getInstance() {
		if (instance == null) {
			instance = new ClassesDAO();
		}
		return instance;
	}

}
