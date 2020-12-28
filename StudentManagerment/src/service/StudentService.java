package service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import dao.StudentDAO;
import entities.Classes;
import entities.Student;

public class StudentService {
	
	private StudentDAO studentDAO;
	
	public StudentService() {
		studentDAO = new StudentDAO();
	}
	
	public Optional<Student> getStudentByID(int id){
		return studentDAO.get(id);
	}
	
	public Collection<Student> getAllStudent(){
		return studentDAO.getAll();
	}
	public ArrayList<Student> getListStudentByClass(int id){
		return studentDAO.getListStudentByClass(id);
	}
	public boolean saveStudent(Student st) {
		if(studentDAO.save(st) > 0) {
			return true;
		}
		return false;
	}
	
	public boolean updateStudent(Student st) {
		if(studentDAO.update(st) > 0) {
			return true;
		}
		return false;
	}
	
	public boolean deleteStudent(Student st) {
		if(studentDAO.delete(st) > 0) {
			return true;
		}
		return false;
	}
}
