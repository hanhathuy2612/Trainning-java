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
import org.huyha.entities.Subjects;
import org.huyha.entities.Teacher;
import org.huyha.service.ClassesService;
import org.huyha.service.Service;
import org.huyha.service.StudentService;
import org.huyha.utils.DataUtils;
import org.huyha.utils.HibernateUtils;

public class App {
	public static void main(String[] args) {

		Subjects subjects = new Subjects(1);

		Teacher teacher = new Teacher(3);

		Classes classes = new Classes(1);

		Student st1 = new Student("Lý Nhã Nhị Ngọc", new Date(), true);
		Student st2 = new Student("Trần Phong Nhã", new Date(), false);
		Student st3 = new Student("Gái Nhật Đó Matamisu", new Date(), true);

		List<Student> listStudent = new ArrayList<Student>();
		listStudent.add(st1);
		listStudent.add(st2);
		listStudent.add(st3);

		Service.getInstance().addListStudentToClass(listStudent, classes, teacher, subjects);

		for (Student st : StudentDAO.getInstance().getAll(Student.class)) {
			System.out.println(st.getName());
		}
	}
}
