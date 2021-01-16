package org.huyha.service;

import java.util.List;

import org.huyha.dao.StudentDAO;
import org.huyha.entities.Classes;
import org.huyha.entities.Student;
import org.huyha.entities.Subjects;
import org.huyha.entities.Teacher;

public class Service {
	private static Service instance;

	public static Service getInstance() {
		if (instance == null) {
			instance = new Service();
		}
		return instance;
	}

	public void addListStudentToClass(List<Student> listStudent, Classes classes, Teacher teacher, Subjects subjects) {
		classes.setSubjects(subjects);
		classes.setTeacher(teacher);
		for (Student st : listStudent) {

			st.setClasses(classes);

			StudentDAO.getInstance().save(st);

		}

	}
}
