package org.huyha.service;

import java.util.Collection;
import java.util.Optional;

import org.huyha.dao.ClassesDAO;
import org.huyha.dao.HibernateDAO;
import org.huyha.entities.Classes;

public class ClassesService {
	private static ClassesService instance;

	public static ClassesService getInstance() {
		if (instance == null) {
			instance = new ClassesService();
		}
		return instance;
	}


}
