package org.huyha.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
import org.huyha.utils.HibernateUtils;

public class Service {
	private static Service instance;

	public static Service getInstance() {
		if (instance == null) {
			instance = new Service();
		}
		return instance;
	}

	public boolean checkContainsSubject(Subjects subjects) {
		for (Subjects temp : SubjectsDAO.getInstance().getAll(Subjects.class)) {
			if (temp.getId() == subjects.getId()) {
				return true;
			}
		}
		return false;
	}

	public boolean checkContainsTeacher(Teacher Teacher) {
		for (Teacher temp : TeacherDAO.getInstance().getAll(Teacher.class)) {
			if (temp.getId() == Teacher.getId()) {
				return true;
			}
		}
		return false;
	}

	public boolean checkContainsClasses(Classes classes) {
		for (Classes temp : ClassesDAO.getInstance().getAll(Classes.class)) {
			if (temp.getIdClass() == classes.getIdClass()) {
				return true;
			}
		}
		return false;
	}

	public void addListStudentToClass(List<Student> listStudent, Classes classes, Teacher teacher, Subjects subjects) {
		Session session = HibernateDAO.getInstance().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			// Check contains subject
			if (!checkContainsSubject(subjects)) {
				SubjectsDAO.getInstance().save(subjects);
			}

			// Check contains teacher
			if (!checkContainsTeacher(teacher)) {
				TeacherDAO.getInstance().save(teacher);
			}

			// Check contains teacher
			if (!checkContainsClasses(classes)) {
				ClassesDAO.getInstance().save(classes);
			}

			classes.setTeacher(teacher);
			classes.setSubjects(subjects);

			for (Student st : listStudent) {
				st.setClasses(classes);
				StudentDAO.getInstance().save(st);

				if (st.isSex() == true) {
					throw new StudentNotAuthorizedException("Giới tính phải toàn là nữ");
				}
			}

			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}

	}

	public void addListStudentToClass(List<Student> listStudent, Classes classes) {
		Session session = HibernateDAO.getInstance().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			for (Student st : listStudent) {

				st.setClasses(classes);

				StudentDAO.getInstance().save(st);

				if (st.getName().toLowerCase().contains("nhật")) {
					throw new StudentNotAuthorizedException("Tên không hợp lệ");
				}
			}

			tx.commit();

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		session.close();
	}

	public List<Student> getAllStudents() {
		Session session = HibernateDAO.getInstance().getCurrentSession();
		List<Student> list = new ArrayList<Student>();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			list = (ArrayList<Student>) StudentDAO.getInstance().getAll(Student.class);

			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
