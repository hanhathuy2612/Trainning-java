package org.huyha.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.huyha.dao.ClassesDAO;
import org.huyha.dao.HibernateDAO;
import org.huyha.dao.StudentDAO;
import org.huyha.dao.SubjectsDAO;
import org.huyha.dao.TeacherDAO;
import org.huyha.entities.Classes;
import org.huyha.entities.Student;
import org.huyha.entities.Subjects;
import org.huyha.entities.Teacher;
import org.huyha.exception.StudentNotAuthorizedException;
import org.huyha.service.ClassesService;
import org.huyha.service.Service;
import org.huyha.service.StudentService;
import org.huyha.utils.DataUtils;
import org.huyha.utils.HibernateUtils;

public class App {
	public static void main(String[] args) {
//
//		Subjects subjects = new Subjects(1);
//
//		Teacher teacher = new Teacher(3);

		Classes classes = new Classes(2);

		Student st1 = new Student("THiên Huy", new Date(), true);
		Student st2 = new Student("Hoa Anh ĐÀo", new Date(), false);
		Student st3 = new Student("Gái Nhật", new Date(), true);

		List<Student> listStudent = new ArrayList<Student>();
		listStudent.add(st1);
		listStudent.add(st2);
		listStudent.add(st3);

		try {
			Service.getInstance().addListStudentToClass(listStudent, classes);
		} catch (StudentNotAuthorizedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//	
		for (Student st : StudentDAO.getInstance().getAll(Student.class)) {
			System.out.println(st.getName());
		}
		
//		for (Teacher te : TeacherDAO.getInstance().getAll(Teacher.class)) {
//			for (Classes cl : te.getClasses()) {
//				System.out.println(cl.getClassName() + ", " + te.getTeacherName());
//			}
//		}
//		for(Subjects su :SubjectsDAO.getInstance().getAll(Subjects.class)) {
//			System.out.println(su.getSubjectName());
//		}
//		System.out.println("Class");
//		for(Classes cl: ClassesDAO.getInstance().getAll(Classes.class)) {
//			System.out.println(cl.getClassName());
//		}
	}
}
