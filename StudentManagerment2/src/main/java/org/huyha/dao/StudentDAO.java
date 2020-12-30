package org.huyha.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.huyha.entities.*;
import org.huyha.utils.MySessionFactory;
public class StudentDAO {
	private static StudentDAO instances;

	public static StudentDAO getInstances() {
		if(instances == null) {
			instances = new StudentDAO();
		}
		return instances;
	}
	
	@SuppressWarnings("deprecation")
	public List<Student> getListStudent(){
		List<Student> listStudent = new ArrayList<Student>();
		try {
			Session session = MySessionFactory.getInstances().openSession();
			session.getTransaction().begin();
			listStudent = session.createCriteria(Student.class).list();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return listStudent;
		
	}
}
