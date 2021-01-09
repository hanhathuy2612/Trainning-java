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

	public Optional<Classes> get(int id, Class<Classes> type) {
		return ClassesDAO.getInstance().get(id, type);
	}

	public Collection<Classes> getAll(Class<Classes> type) {
		return ClassesDAO.getInstance().getAll(type);
	}

	public boolean save(Classes t) {
		if (ClassesDAO.getInstance().save(t) == 1) {
			return true;
		}
		return false;
	}

	public boolean update(Classes t) {
		if (ClassesDAO.getInstance().update(t) == 1) {
			return true;
		}
		return false;
	}

	public boolean delete(Classes t) {
		if (ClassesDAO.getInstance().delete(t) == 1) {
			return true;
		}
		return false;
	}

}
