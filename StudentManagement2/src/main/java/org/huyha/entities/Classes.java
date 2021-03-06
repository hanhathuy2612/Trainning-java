package org.huyha.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Classes")
public class Classes {
	private int idClass;
	private String className;
	private Set<Student> employees = new HashSet<Student>(0);

	public Classes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Classes(String className) {
		super();
		this.className = className;
	}

	@Id
	@Column(name = "ID_Class")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getIdClass() {
		return idClass;
	}

	@Column(name = "className")
	public String getClassName() {
		return className;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "classes")
	public Set<Student> getEmployees() {
		return employees;
	}

	public void setIdClass(int idClass) {
		this.idClass = idClass;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public void setEmployees(Set<Student> employees) {
		this.employees = employees;
	}

}
