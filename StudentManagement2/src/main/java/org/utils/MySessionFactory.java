package org.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MySessionFactory {
	private static SessionFactory fac = null;

	public static SessionFactory getFac() {
		if(fac == null) {
			fac	 = new Configuration().configure().buildSessionFactory();
		}
		return fac;
	}
	
}
