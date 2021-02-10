package org.huyha.service;

public class ClassesService {
	private static ClassesService instance;

	public static ClassesService getInstance() {
		if (instance == null) {
			instance = new ClassesService();
		}
		return instance;
	}


}
