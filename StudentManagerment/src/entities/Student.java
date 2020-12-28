package entities;

import java.sql.Date;

public class Student {
	private int id;
	private String name;
	private String dateOfBirth;
	private String sex;
	private Classes classes;
	
	public Student() {
		super();
		classes = new Classes();
	}
	public Student(int iD, String name, String dateOfBirth, String sex, Classes classes) {
		super();
		id = iD;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.sex = sex;
		this.classes = classes;
	}
	
	public Student(int iD) {
		super();
		id = iD;
	}
	public Student(String name, String dateOfBirth, String sex, Classes classes) {
		super();
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.sex = sex;
		this.classes = classes;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Classes getClasses() {
		return classes;
	}
	public void setClasses(Classes classes) {
		this.classes = classes;
	}
	@Override
	public String toString() {
		return "Student [" + id + ", " + name + ", " + dateOfBirth + ", " + sex + ", "
				+ classes.getIdClass() + "]\n";
	}
	
	
}
