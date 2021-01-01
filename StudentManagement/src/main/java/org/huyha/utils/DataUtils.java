package org.huyha.utils;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.huyha.entities.Classes;
import org.huyha.entities.Student;

public class DataUtils {
	public static Student findStudent(Session session, int id) {
		String sql = "Select d from " + Student.class.getName() + " d "//
				+ " Where d.id = :ID";
		Query<Student> query = session.createQuery(sql);
		query.setParameter("ID", id);
		return query.getSingleResult();
	}

	public static int getMaxStudentId(Session session) {
		String sql = "Select max(e.empId) from " + Student.class.getName() + " e ";
		Query<Number> query = session.createQuery(sql);
		Number value = query.getSingleResult();
		if (value == null) {
			return 0;
		}
		return (int) value.longValue();
	}

	public static Classes findEmployee(Session session, String empNo) {
		String sql = "Select e from " + Classes.class.getName() + " e "//
				+ " Where e.ID_Class = :ID";
		Query<Classes> query = session.createQuery(sql);
		query.setParameter("ID", empNo);
		return query.getSingleResult();
	}
}
