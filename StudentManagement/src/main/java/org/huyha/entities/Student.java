package org.huyha.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "name")
	private String name;

	@Column(name = "dateOfBirth")
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;

	@Column(name = "sex")
	private boolean sex;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_Class")
	private Classes classes;

	public Student() {

	}

	public Student(String name, Date dateOfBirth, boolean sex) {
		super();
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.sex = sex;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public boolean isSex() {
		return sex;
	}

	public Classes getClasses() {
		return classes;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public void setClasses(Classes classes) {
		this.classes = classes;
	}

	@Override
	public String toString() {
		return "Student [getId()=" + getId() + ", getName()=" + getName() + ", getDateOfBirth()=" + getDateOfBirth()
				+ ", isSex()=" + isSex() + ", getClasses()=" + getClasses() + "]";
	}

}
