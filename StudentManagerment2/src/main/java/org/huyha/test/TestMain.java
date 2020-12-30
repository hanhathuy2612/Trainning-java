package org.huyha.test;

import java.util.ArrayList;
import java.util.List;

import org.huyha.dao.StudentDAO;
import org.huyha.entities.Student;

public class TestMain {
	public static void main(String[] args) {
		List<Student> list =  StudentDAO.getInstances().getListStudent();
//		for(int i = 0;i < list.size();i++) {
//			System.out.println(list.get(i));
//		}
		for(Object item: list) {
			System.out.println(item);
		}
	}
}
