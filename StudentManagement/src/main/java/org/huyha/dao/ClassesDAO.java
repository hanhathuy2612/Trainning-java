package org.huyha.dao;

import java.util.Collection;
import java.util.Optional;

import org.huyha.entities.Classes;

public class ClassesDAO implements Dao<Classes> {

	public Optional<Classes> get(int id, Class<Classes> type) {
		return HibernateDAO.getInstance().get(id, type);
	}

	public Collection<Classes> getAll(Class<Classes> type) {
		return HibernateDAO.getInstance().getAll(type);
	}

	public int save(Classes t) {
		return HibernateDAO.getInstance().save(t);
	}

	public int update(Classes t) {
		return HibernateDAO.getInstance().update(t);
	}

	public int delete(Classes t) {
		return HibernateDAO.getInstance().delete(t);
	}

}
