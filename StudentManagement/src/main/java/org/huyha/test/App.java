package org.huyha.test;

import org.huyha.entities.Student;
import org.huyha.entities.Teacher;
import org.huyha.service.Service;

public class App {
	public static void main(String[] args) {

//		Subjects subjects = new Subjects(1);
//
//		Teacher teacher = new Teacher(3);
//
//		Classes classes = new Classes(2);
//
//		Student st1 = new Student("Lý Thái Tài", new Date(), false);
//		Student st2 = new Student("Trai Nhật Đó", new Date(), false);
//		Student st3 = new Student("Gái Italia", new Date(), false);
//		Student st4 = new Student("Hoa Quần Hoa", new Date(), false);
//		Student st5 = new Student("Hồ Nguyễn Liên Hoa", new Date(), true);
//
//		List<Student> listStudent = new ArrayList<Student>();
//		listStudent.add(st1);
//		listStudent.add(st2);
//		listStudent.add(st3);
//		listStudent.add(st4);
//		listStudent.add(st5);
//
//		Service.getInstance().addListStudentToClass(listStudent, classes, teacher, subjects);

//		for (Student st : Service.getInstance().getAllStudents()) {
//			System.out.println(st.getId() + ", " + st.getName());
//		}
		
		for(Student st : Service.getInstance().getStudentByTeacher(new Teacher("Teacher 1"))) {
			System.out.println(st.getId() + ", " + st.getName());
		}

	}
}
