package service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import dao.ClassesDAO;
import dao.Dao;
import entities.Classes;

public class ClassesService {
	private static ClassesService instance;
	
	

	public static ClassesService getInstance() {
		if(instance == null) {
			instance = new ClassesService();
		}
		return instance;
	}
	public static void setInstance(ClassesService instance) {
		ClassesService.instance = instance;
	}
	public Optional<Classes> getClassById(int id) {
		return ClassesDAO.getInstances().get(id);
	}
	public Collection<Classes> getAllClass(){
		return ClassesDAO.getInstances().getAll();
	}
	
	public boolean saveClass(Classes classes) {
		if(ClassesDAO.getInstances().save(classes) > 0) {
			return true;
		}
		return false;
	}
	
	public boolean updateClass(Classes classes) {
		if(ClassesDAO.getInstances().update(classes) > 0) {
			return true;
		}
		return false;
	}
	
	public boolean deleteClass(Classes classes) {
		if(ClassesDAO.getInstances().delete(classes) > 0) {
			return true;
		}
		return false;
	}
}
