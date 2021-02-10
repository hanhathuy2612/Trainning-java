package org.huyha.service;

public class StudentService {
	private static StudentService instance;

	public static StudentService getInstance() {
		if (instance == null) {
			instance = new StudentService();
		}
		return instance;
	}

}
