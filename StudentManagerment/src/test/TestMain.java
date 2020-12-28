package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import dao.ClassesDAO;
import dao.StudentDAO;
import entities.Classes;
import entities.Student;
import service.ClassesService;
import service.StudentService;

public class TestMain {
	public static StudentService studentService;
	public static ClassesService classesService;
	
	public static void menu() {
		System.out.println("1. Show All students");
		System.out.println("2. Add student");
		System.out.println("3. Edit Student");
		System.out.println("4. Delete Student");
		System.out.println("5. Show All Class");
		System.out.println("6. Show All Student in class");
		System.out.println("7. Add Class");
		System.out.println("8. Edit Class");
		System.out.println("9. Delete Class");
		System.out.println("10. Exit");
	}
	/*
	 * 1.
	 */
	public static void showAllStudent() {
		studentService = new StudentService();
		Collection<Student> listStudent = studentService.getAllStudent();
		System.out.println("========== List students ==========");
		System.out.println(listStudent);
	}
	/*
	 * 2.
	 */
	public static boolean addStudent() {
		studentService = new StudentService();
		System.out.print("input Name: ");
		String name = new Scanner(System.in).nextLine();

		System.out.print("input DateOfBirth (YYYY-MM-DD): ");
		String dateOfBirth = new Scanner(System.in).nextLine();

		System.out.print("input sex: ");
		String sex = new Scanner(System.in).nextLine();

		System.out.print("input ID_Class: ");
		int id_Class = new Scanner(System.in).nextInt();

		Classes classes = new Classes(id_Class);
		Student st = new Student(name, dateOfBirth, sex, classes);
		
		return studentService.saveStudent(st);
	}
	/*
	 * 3.
	 */
	
	public static boolean updateStudent() {
		studentService = new StudentService();
		System.out.print("Choose student to edit by id: ");
		int id = new Scanner(System.in).nextInt();
		if (studentService.getStudentByID(id) != null) {
			System.out.print("input Name: ");
			String name = new Scanner(System.in).nextLine();

			System.out.print("input DateOfBirth (YYYY-MM-DD): ");
			String dateOfBirth = new Scanner(System.in).nextLine();

			System.out.print("input sex: ");
			String sex = new Scanner(System.in).nextLine();

			System.out.print("input ID_Class: ");
			int id_Class = new Scanner(System.in).nextInt();

			Classes classes = new Classes(id_Class);
			Student st = new Student(id,name, dateOfBirth, sex, classes);
			
			return studentService.updateStudent(st);
		} else {
			System.out.println("Student do not exist");
		}
		return false;
	}
	/*
	 * 4.
	 */
	public static boolean deleteStudent() {
		studentService = new StudentService();
		System.out.print("Choose student to delete by id: ");
		int id = new Scanner(System.in).nextInt();
		if (studentService.getStudentByID(id) != null) {
			Student student = new Student(id);
			return studentService.deleteStudent(student);
		} else {
			System.out.println("Student do not exist");
		}
		return false;
	}
	/*
	 * 5.
	 */
	public static void showAllClass() {
		classesService = new ClassesService();
		ArrayList<Classes> listStudent = (ArrayList<Classes>)classesService.getAllClass();
		System.out.println("========== List Class ==========");
		System.out.println(listStudent);
	}
	/*
	 * 6.
	 */
	public static void showListStudenByClass() {
		studentService = new StudentService();
		System.out.println("Input Id class: ");
		int id_class = new Scanner(System.in).nextInt();
		List<Student> listStudent = studentService.getListStudentByClass(id_class);
		if(listStudent.size() > 0) {
			System.out.println(listStudent);
		}else {
			System.out.println("Class do not exist");
		}
	}
	/*
	 * 7.
	 */
	public static boolean saveClass() {
		classesService = new ClassesService();
		System.out.println("Input ClassName: ");
		String className = new Scanner(System.in).nextLine();
		Classes classes = new Classes(className);
		return classesService.saveClass(classes);
	}
	/*
	 * 8.
	 */
	public static boolean updateClass() {
		classesService = new ClassesService();
		System.out.println("Input id class to edit: ");
		int id_Class = new Scanner(System.in).nextInt();
		if(classesService.getClassById(id_Class) != null) {
			System.out.println("Input ClassName: ");
			String className = new Scanner(System.in).nextLine();
			Classes classes = new Classes(id_Class,className);
			
			return classesService.updateClass(classes);
		}else {
			System.out.println("Class do not exist");
		}
		return false;
	}
	/*
	 * 9.
	 */
	public static boolean deleteClass() {
		classesService = new ClassesService();
		System.out.println("Input id class to delete: ");
		int id_Class = new Scanner(System.in).nextInt();
		
		if(classesService.getClassById(id_Class) != null) {
			Classes classes = new Classes(id_Class);
			return classesService.deleteClass(classes);
		}else {
			System.out.println("Class do not exist");
		}
		return false;
	}
	public static void main(String[] args) {
		Scanner sr = new Scanner(System.in);
		while (true) {
			menu();
			System.out.print("Your choice: ");
			int choose = new Scanner(System.in).nextInt();
			switch (choose) {
			case 1:
				showAllStudent();
				break;
			case 2:
				if (addStudent()) {
					System.out.println("Add sucessfully.........");
				} else {
					System.out.println("Add Fail........");
				}
				break;
			case 3:
				if (updateStudent()) {
					System.out.println("Edit sucessfully.........");
				} else {
					System.out.println("Edit Fail........");
				}
				break;
			case 4:
				if (deleteStudent()) {
					System.out.println("Delete sucessfully.........");
				} else {
					System.out.println("Delete Fail........");
				}
				break;
			case 5:
				showAllClass();
				break;
			case 6:
				showListStudenByClass();
				break;
			case 7:
				if(saveClass()) {
					System.out.println("Add class sucessfully");
				}else {
					System.out.println("Add class fail");
				}
				break;
			case 8:
				if(updateClass()) {
					System.out.println("Edit class sucessfully");
				}else {
					System.out.println("Edit class fail");
				}
				break;
			case 9:
				if(deleteClass()) {
					System.out.println("Delete class sucessfully");
				}else {
					System.out.println("Delete class fail");
				}
				break;
			case 10:
				System.out.println("Exit................................bye..bye!!!");
				System.exit(0);
			}
		}
	}
}
