package org.huyha.StudentManagement;

import org.huyha.dao.ClassesDAO;
import org.huyha.dao.StudentDAO;
import org.huyha.entities.Classes;
import org.huyha.entities.Student;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest {
	public static void main(String[] args) {

		for (Student tem : StudentDAO.getStudentDAO().getAll()) {
			System.out.println(tem.getName());
		}

//		for (Classes tem : ClassesDAO.getClassesDAO().getAll()) {
//			System.out.println(tem.getClassName());
//		}
	}
}
