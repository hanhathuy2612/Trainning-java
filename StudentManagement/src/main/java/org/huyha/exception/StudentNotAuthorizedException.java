package org.huyha.exception;

import org.huyha.entities.Student;
import org.huyha.utils.HibernateUtils;

public class StudentNotAuthorizedException extends Exception {
	public StudentNotAuthorizedException(String st) {
		super(st);
	}
}
