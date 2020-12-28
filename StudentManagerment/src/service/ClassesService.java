package service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import dao.ClassesDAO;
import dao.Dao;
import entities.Classes;

public class ClassesService {
	private Dao<Classes> clDao;
	
	public ClassesService() {
		clDao = new ClassesDAO();
	}

	public Optional<Classes> getClassById(int id) {
		return clDao.get(id);
	}
	public Collection<Classes> getAllClass(){
		return clDao.getAll();
	}
	
	public boolean saveClass(Classes classes) {
		if(clDao.save(classes) > 0) {
			return true;
		}
		return false;
	}
	
	public boolean updateClass(Classes classes) {
		if(clDao.update(classes) > 0) {
			return true;
		}
		return false;
	}
	
	public boolean deleteClass(Classes classes) {
		if(clDao.delete(classes) > 0) {
			return true;
		}
		return false;
	}
}
