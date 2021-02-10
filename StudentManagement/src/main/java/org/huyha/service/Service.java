package org.huyha.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.hibernate.Session;
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

public class Service {
	private StudentDAO studentDAO = StudentDAO.getInstance();
	private ClassesDAO classesDAO = ClassesDAO.getInstance();
	private TeacherDAO teacherDAO = TeacherDAO.getInstance();
	private SubjectsDAO subjectsDAO = SubjectsDAO.getInstance();
	private static Service instance;

	public static Service getInstance() {
		if (instance == null) {
			instance = new Service();
		}
		return instance;
	}

	public boolean checkContainsSubject(Subjects subjects) {
		for (Subjects temp : subjectsDAO.getAll()) {
			if (temp.getId() == subjects.getId()) {
				return true;
			}
		}
		return false;
	}

	public boolean checkContainsTeacher(Teacher Teacher) {
		for (Teacher temp : teacherDAO.getAll()) {
			if (temp.getId() == Teacher.getId()) {
				return true;
			}
		}
		return false;
	}

	public boolean checkContainsClasses(Classes classes) {
		for (Classes temp : classesDAO.getAll()) {
			if (temp.getIdClass() == classes.getIdClass()) {
				return true;
			}
		}
		return false;
	}

	public void addListStudentToClass(List<Student> listStudent, Classes classes, Teacher teacher, Subjects subjects) {
		Session session = HibernateDAO.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			// Check contains subject
			if (!checkContainsSubject(subjects)) {
				subjectsDAO.save(subjects);
			}

			// Check contains teacher
			if (!checkContainsTeacher(teacher)) {
				teacherDAO.save(teacher);
			}

			// Check contains teacher
			if (!checkContainsClasses(classes)) {
				classesDAO.save(classes);
			}

			classes.setTeacher(teacher);
			classes.setSubjects(subjects);

			for (Student st : listStudent) {
				st.setClasses(classes);
				studentDAO.save(st);

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
		Session session = HibernateDAO.getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			for (Student st : listStudent) {

				st.setClasses(classes);

				studentDAO.save(st);

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
		Session session = HibernateDAO.getCurrentSession();
		List<Student> list = new ArrayList<Student>();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			list = studentDAO.getAll();

			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * get students by teacher
	 */
	public ArrayList<Student> getStudentByTeacher(Teacher teacher) {
		Session session = HibernateDAO.getCurrentSession();

		ArrayList<Student> students = new ArrayList<Student>();

		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			Optional<Teacher> teacher2 = teacherDAO.get(teacher.getId());

			Set<Classes> classes = teacher2.get().getClasses();

			for (Classes temp : classes) {
				for (Student st : temp.getStudents()) {
					students.add(st);
				}
			}

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return students;
	}
}
