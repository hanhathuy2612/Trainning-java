package org.dao;

import java.util.ArrayList;
import java.util.List;


import org.entities.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.utils.MySessionFactory;

public class StudentDAO {
	private static StudentDAO instances;
	
	public static StudentDAO getInstances() {
		if(instances == null) {
			instances = new StudentDAO();
		}
		return instances;
	}
	public List<Student> getAllStudent() {
		List<Student> data = new ArrayList<Student>();
		Session sess = MySessionFactory.getFac().openSession();
		Transaction tx = null;
		try {
			tx = sess.beginTransaction();
			data = sess.createQuery("FROM Student").list();
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		sess.close();
		return data;
	}
	public static void main(String[] args) {
		System.out.println(StudentDAO.getInstances().getAllStudent());
	}
}
