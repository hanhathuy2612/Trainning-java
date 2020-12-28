package service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import dao.StudentDAO;
import entities.Classes;
import entities.Student;

public class StudentService {
	
	private static StudentService instances;
	
	public static StudentService getInstances() {
		if(instances == null) {
			instances = new StudentService();
		}
		return instances;
	}
	
	public Optional<Student> getStudentByID(int id){
		return StudentDAO.getInstances().get(id);
	}
	
	public Collection<Student> getAllStudent(){
		return StudentDAO.getInstances().getAll();
	}
	public ArrayList<Student> getListStudentByClass(int id){
		return StudentDAO.getInstances().getListStudentByClass(id);
	}
	public boolean saveStudent(Student st) {
		if(StudentDAO.getInstances().save(st) > 0) {
			return true;
		}
		return false;
	}
	
	public boolean updateStudent(Student st) {
		if(StudentDAO.getInstances().update(st) > 0) {
			return true;
		}
		return false;
	}
	
	public boolean deleteStudent(Student st) {
		if(StudentDAO.getInstances().delete(st) > 0) {
			return true;
		}
		return false;
	}
}
