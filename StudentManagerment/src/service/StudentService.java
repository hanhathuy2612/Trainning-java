package service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import dao.StudentDAO;
import entities.Classes;
import entities.Student;

public class StudentService implements Service<Student>{
	
	private static StudentService instances;
	
	public static StudentService getInstances() {
		if(instances == null) {
			instances = new StudentService();
		}
		return instances;
	}
	public ArrayList<Student> getListStudentByClass(int idClass){
		return StudentDAO.getInstances().getListStudentByClass(idClass);
	}
	@Override
	public Optional<Student> get(int id) {
		return StudentDAO.getInstances().get(id);
	}

	@Override
	public Collection<Student> getAll() {
		return StudentDAO.getInstances().getAll();
	}

	@Override
	public boolean save(Student t) {
		if(StudentDAO.getInstances().save(t) > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean update(Student t) {
		if(StudentDAO.getInstances().update(t) > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(Student t) {
		if(StudentDAO.getInstances().delete(t) > 0) {
			return true;
		}
		return false;
	}
}
