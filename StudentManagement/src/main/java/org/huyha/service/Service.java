package org.huyha.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.huyha.dao.StudentDAO;
import org.huyha.entities.Classes;
import org.huyha.entities.Student;
import org.huyha.entities.Subjects;
import org.huyha.entities.Teacher;
import org.huyha.exception.StudentNotAuthorizedException;
import org.huyha.utils.HibernateUtils;

public class Service {
	private static Service instance;

	public static Service getInstance() {
		if (instance == null) {
			instance = new Service();
		}
		return instance;
	}

//	public void addListStudentToClass(List<Student> listStudent, Classes classes, Teacher teacher, Subjects subjects)
//			throws Exception {
//
//		classes.setSubjects(subjects);
//		classes.setTeacher(teacher);
//
//		for (Student st : listStudent) {
//
//			st.setClasses(classes);
//
//			StudentDAO.getInstance().save(st);
//
//		}
//
//	}

	public void addListStudentToClass(List<Student> listStudent, Classes classes) throws Exception {
		int check = 0;

		SessionFactory factory = HibernateUtils.getSessionFactory();

		Session session = null;

		Transaction tx = null;
		
		session = factory.getCurrentSession();

		tx = session.beginTransaction();

		for (Student st : listStudent) {

			st.setClasses(classes);

			session.save(st);

			if (st.getName().toLowerCase().contains("nhật")) {

				check = 1;

				tx.rollback();

				throw new StudentNotAuthorizedException("Tên không hợp lệ");

			}
		}

		if (check == 0) {
			tx.commit();
		}

	}
}
