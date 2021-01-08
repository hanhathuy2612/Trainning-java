package org.huyha.test;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.huyha.dao.ClassesDAO;
import org.huyha.dao.StudentDAO;
import org.huyha.entities.Classes;
import org.huyha.entities.Student;
import org.huyha.utils.DataUtils;
import org.huyha.utils.HibernateUtils;

public class App {
	public static void main(String[] args) {
		
		for (Student st : StudentDAO.getStudentDAO().getAll()) {
			System.out.println(st.getId() + ", " + st.getName());
		}
//		Student student = StudentDAO.getStudentDAO().get(26).get();
//		student.setName("Hà Nhật Chương");
//		if (StudentDAO.getStudentDAO().update(student) == 1) {
//			System.out.println("Save sucesssful");
//		} else {
//			System.out.println("Save fail");
//		}
//		for (Student st : StudentDAO.getStudentDAO().getAll()) {
//			System.out.println(st.getId() + ", " + st.getName());
//		}
//		System.out.println(StudentDAO.getStudentDAO().get(2).get().getName());
//		System.out.println(ClassesDAO.getClassesDAO().get(1).get().getClassName());
	}
}
