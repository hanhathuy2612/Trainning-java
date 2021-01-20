package org.huyha.dao;

import java.util.Collection;
import java.util.Optional;

import org.huyha.entities.Classes;

public class ClassesDAO extends HibernateDAO<Classes> {
	private static ClassesDAO instance;

	public static ClassesDAO getInstance() {
		if (instance == null) {
			instance = new ClassesDAO();
		}
		return instance;
	}

}
