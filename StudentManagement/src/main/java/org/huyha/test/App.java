package org.huyha.test;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.huyha.dao.HibernateDAO;
import org.huyha.entities.Classes;
import org.huyha.entities.Student;
import org.huyha.service.ClassesService;
import org.huyha.utils.DataUtils;
import org.huyha.utils.HibernateUtils;

public class App {
	public static void main(String[] args) {
		Classes classes = new Classes("Lớp F");
		if (ClassesService.getInstance().save(classes)) {
			System.out.println("Save sucessful");
		} else {
			System.out.println("Save fail");
		}

	}
}
