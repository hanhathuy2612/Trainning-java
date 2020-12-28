package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import dao.ClassesDAO;
import dao.StudentDAO;
import entities.Classes;
import entities.Student;

public class TestMain {
	public static StudentDAO studentDAO;
	public static ClassesDAO classDAO;
	
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
	public static void ShowAllStudent() {
		studentDAO = new StudentDAO();
		ArrayList<Student> listStudent = studentDAO.getAllStudent();
		System.out.println("========== List students ==========");
		System.out.println(listStudent);
	}
	/*
	 * 2.
	 */
	public static boolean AddStudent() {
		studentDAO = new StudentDAO();
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
		if (studentDAO.AddStudent(st) > 0) {
			return true;
		}
		return false;
	}
	/*
	 * 3.
	 */
	
	public static boolean EditStudent() {
		studentDAO = new StudentDAO();
		System.out.print("Choose student to edit by id: ");
		int id = new Scanner(System.in).nextInt();
		if (studentDAO.GetStudentByID(id) > 0) {
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
			if (studentDAO.EditStudent(st) > 0) {
				return true;
			}
			return false;
		} else {
			System.out.println("Student do not exist");
		}
		return false;
	}
	/*
	 * 4.
	 */
	public static boolean DeleteStudent() {
		studentDAO = new StudentDAO();
		System.out.print("Choose student to delete by id: ");
		int id = new Scanner(System.in).nextInt();
		
		if (studentDAO.GetStudentByID(id) > 0) {
			if (studentDAO.deleteStudent(id) > 0) {
				return true;
			}
			return false;
		} else {
			System.out.println("Student do not exist");
		}
		return false;
	}
	/*
	 * 5.
	 */
	public static void ShowAllClass() {
		classDAO = new ClassesDAO();
		ArrayList<Classes> listStudent = classDAO.getAllClass();
		System.out.println("========== List Class ==========");
		System.out.println(listStudent);
	}
	/*
	 * 6.
	 */
	public static void ShowListStudenByClass() {
		System.out.println("Input Id class: ");
		studentDAO = new StudentDAO();
		int id_class = new Scanner(System.in).nextInt();
		List<Student> listStudent = studentDAO.getListStudentByClass(id_class);
		if(listStudent.size() > 0) {
			System.out.println(listStudent);
		}else {
			System.out.println("Class do not exist");
		}
	}
	/*
	 * 7.
	 */
	public static boolean AddClass() {
		classDAO = new ClassesDAO();
		System.out.println("Input ClassName: ");
		String className = new Scanner(System.in).nextLine();
		Classes classes = new Classes(className);
		if(classDAO.AddClass(classes) > 0) {
			return true;
		}else {
			return false;
		}
	}
	/*
	 * 8.
	 */
	public static boolean EditClass() {
		classDAO = new ClassesDAO();
		System.out.println("Input id class to edit: ");
		int id_Class = new Scanner(System.in).nextInt();
		if(classDAO.GetClassByID(id_Class) > 0) {
			System.out.println("Input ClassName: ");
			String className = new Scanner(System.in).nextLine();
			Classes classes = new Classes(id_Class,className);
			if(classDAO.EditClass(classes) > 0) {
				return true;
			}else {
				return false;
			}
		}else {
			System.out.println("Class do not exist");
		}
		return false;
	}
	/*
	 * 9.
	 */
	public static boolean DeleteClass() {
		classDAO = new ClassesDAO();
		System.out.println("Input id class to delete: ");
		int id_Class = new Scanner(System.in).nextInt();
		
		if(classDAO.GetClassByID(id_Class) > 0) {
			Classes classes = new Classes(id_Class);
			System.out.println(classDAO.DeleteClass(id_Class));
			if(classDAO.DeleteClass(id_Class) >= 0) {
				return true;
			}else {
				return false;
			}
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
				ShowAllStudent();
				break;
			case 2:
				if (AddStudent()) {
					System.out.println("Add sucessfully.........");
				} else {
					System.out.println("Add Fail........");
				}
				break;
			case 3:
				if (EditStudent()) {
					System.out.println("Edit sucessfully.........");
				} else {
					System.out.println("Edit Fail........");
				}
				break;
			case 4:
				if (DeleteStudent()) {
					System.out.println("Delete sucessfully.........");
				} else {
					System.out.println("Delete Fail........");
				}
				break;
			case 5:
				ShowAllClass();
				break;
			case 6:
				ShowListStudenByClass();
				break;
			case 7:
				if(AddClass()) {
					System.out.println("Add class sucessfully");
				}else {
					System.out.println("Add class fail");
				}
				break;
			case 8:
				if(EditClass()) {
					System.out.println("Edit class sucessfully");
				}else {
					System.out.println("Edit class fail");
				}
				break;
			case 9:
				if(DeleteClass()) {
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
