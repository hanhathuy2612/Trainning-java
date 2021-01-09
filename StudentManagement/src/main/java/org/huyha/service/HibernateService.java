package org.huyha.service;

import java.util.Collection;
import java.util.Optional;

import org.huyha.dao.HibernateDAO;

public class HibernateService<T> implements Serviece<T> {
	private static HibernateService instance;

	public static HibernateService getInstance() {
		if (instance == null) {
			instance = new HibernateService();
		}
		return instance;
	}

	public Optional<T> get(int id, Class<T> type) {
		return HibernateDAO.getInstance().get(id, type);
	}

	public Collection<T> getAll(Class<T> type) {
		return HibernateDAO.getInstance().getAll(type);
	}

	public boolean save(T t) {
		if (HibernateDAO.getInstance().save(t) == 1) {
			return true;
		}
		return false;
	}

	public boolean update(T t) {
		if (HibernateDAO.getInstance().update(t) == 1) {
			return true;
		}
		return false;
	}

	public boolean delete(T t) {
		if (HibernateDAO.getInstance().delete(t) == 1) {
			return true;
		}
		return false;
	}

}
