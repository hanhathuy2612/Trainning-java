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
import org.huyha.entities.Classes;
import org.huyha.entities.Student;
import org.huyha.service.ClassesService;
import org.huyha.service.Service;
import org.huyha.service.StudentService;
import org.huyha.utils.DataUtils;
import org.huyha.utils.HibernateUtils;

public class App {
	public static void main(String[] args) {
		Classes classes = new Classes(2);
		
		Student st1 = new Student("Hà Nhật Huy", new Date(), true);
		Student st2 = new Student("Lý Kim Nhân", new Date(), false);
		Student st3 = new Student("Đào Minh Nhật", new Date(), true);
		
		List<Student> listStudent = new ArrayList<Student>();
		listStudent.add(st1);
		listStudent.add(st2);
		listStudent.add(st3);
		
		Service.getInstance().addListStudentToClass(listStudent, classes);
		
		for(Student st: StudentDAO.getInstance().getAll(Student.class)) {
			System.out.println(st.getName());
		}
	}
}
