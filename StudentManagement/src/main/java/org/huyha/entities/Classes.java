package org.huyha.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Classes")
public class Classes {

	@Id
	@Column(name = "ID_Class")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idClass;

	@Column(name = "className")
	private String className;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdSubjects")
	private Subjects subjects;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdTeacher")
	private Teacher teacher;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "classes")
	private Set<Student> students = new HashSet<Student>(0);

	public Classes() {
		super();
	}

	public Classes(int idClass) {
		super();
		this.idClass = idClass;
	}

	public Classes(String className) {
		super();
		this.className = className;
	}

	public int getIdClass() {
		return idClass;
	}

	public String getClassName() {
		return className;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setIdClass(int idClass) {
		this.idClass = idClass;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public Subjects getSubjects() {
		return subjects;
	}

	public void setSubjects(Subjects subjects) {
		this.subjects = subjects;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

}
