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

import org.huyha.dao.HibernateDAO;

@Entity
@Table(name = "Student")
public class Student extends HibernateDAO<Student>{
	private int id;
	private String name;
	private Date dateOfBirth;
	private boolean sex;
	private Classes classes;

	public Student() {

	}

	public Student(String name, Date dateOfBirth, boolean sex) {
		super();
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.sex = sex;
	}

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	@Column(name = "dateOfBirth")
	@Temporal(TemporalType.DATE)
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	@Column(name = "sex")
	public boolean isSex() {
		return sex;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_Class")
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
