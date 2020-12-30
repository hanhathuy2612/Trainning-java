package org.huyha.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MySessionFactory {
	private static SessionFactory instances = null;

	public static SessionFactory getInstances() {
		if (instances == null) {
			instances = new Configuration().configure().buildSessionFactory();
		}
		
		return instances;
	}
}
