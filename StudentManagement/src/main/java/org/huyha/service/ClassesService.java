package org.huyha.service;

import java.util.Collection;
import java.util.Optional;

import org.huyha.dao.ClassesDAO;
import org.huyha.entities.Classes;

public class ClassesService implements Serviece<Classes> {
	private static ClassesService service;

	public static ClassesService getService() {
		if (service == null) {
			service = new ClassesService();
		}
		return service;
	}

	public Optional<Classes> get(int id) {
		return ClassesDAO.getClassesDAO().get(id);
	}

	public Collection<Classes> getAll() {
		return ClassesDAO.getClassesDAO().getAll();
	}

	public boolean save(Classes t) {
		if (ClassesDAO.getClassesDAO().save(t) != 0) {
			return true;
		}
		return false;
	}

	public boolean update(Classes t) {
		if (ClassesDAO.getClassesDAO().update(t) != 0) {
			return true;
		}
		return false;
	}

	public boolean delete(Classes t) {
		if (ClassesDAO.getClassesDAO().delete(t) != 0) {
			return true;
		}
		return false;
	}

}
