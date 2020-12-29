package service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import dao.ClassesDAO;
import dao.Dao;
import entities.Classes;

public class ClassesService implements Service<Classes>{
	private static ClassesService instance;

	public static ClassesService getInstance() {
		if(instance == null) {
			instance = new ClassesService();
		}
		return instance;
	}
	@Override
	public Optional<Classes> get(int id) {
		return ClassesDAO.getInstances().get(id);
	}

	@Override
	public Collection<Classes> getAll() {
		return ClassesDAO.getInstances().getAll();
	}

	@Override
	public boolean save(Classes t) {
		if(ClassesDAO.getInstances().save(t) > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean update(Classes t) {
		if(ClassesDAO.getInstances().update(t) > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(Classes t) {
		if(ClassesDAO.getInstances().delete(t) >= 0) {
			return true;
		}
		return false;
	}
}
