package service;

import java.util.List;

import entities.Student;

public interface StudentService {
	
	List<Student> GetAllStudent();
	
	int GetStudentByID(int id);
	
	int AddStudent(Student st);
	
	int EditStudent(Student st);
	
	int deleteStudent(int id);
}
