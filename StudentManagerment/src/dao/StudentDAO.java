package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.Classes;
import entities.Student;

public class StudentDAO {
	/*
	 * get
	 */
	public ArrayList<Student> getAllStudent(){
		ArrayList<Student> listStudent = new ArrayList<Student>();
		Connection con = new DataConnection().getcn();
		if(con == null) {
			return null;
		}
		try {
			String query = "SELECT * FROM Student";
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("ID");
				String name = rs.getString("Name");
				String dateOfBirth = rs.getString("DateOfBirth");
				String sex = "";
				if(rs.getInt("Sex") == 0) {
					sex = "Nữ";
				}else {
					sex = "Nam";
				}
				Classes classes = new Classes(rs.getInt("ID_Class"));
				Student st = new Student(id, name, dateOfBirth, sex, classes);
				listStudent.add(st);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return listStudent;
	}
	/*
	 * 
	 */
	public ArrayList<Student> getListStudentByClass(int id_class){
		ArrayList<Student> listStudent = new ArrayList<Student>();
		Connection con = new DataConnection().getcn();
		if(con == null) {
			return null;
		}
		try {
			String query = "SELECT * FROM Student where ID_Class = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id_class);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("ID");
				String name = rs.getString("Name");
				String dateOfBirth = rs.getString("DateOfBirth");
				String sex = "";
				if(rs.getInt("Sex") == 0) {
					sex = "Nữ";
				}else {
					sex = "Nam";
				}
				Classes classes = new Classes(rs.getInt("ID_Class"));
				Student st = new Student(id, name, dateOfBirth, sex, classes);
				listStudent.add(st);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return listStudent;
	}
	/*
	 * 
	 */
	public int GetStudentByID(int id) {
		int kq = 0;
		Connection con = new DataConnection().getcn();
		if(con == null) {
			return -1;
		}
		try {
			String query = "SELECT * FROM Student where id = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				kq++;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return kq;
	}
	/*
	 * 
	 */
	public int AddStudent(Student st){
		int kq = 0;
		Connection con = new DataConnection().getcn();
		if(con == null) {
			return -1;
		}
		try {
			String query = "INSERT INTO Student VALUES (?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, st.getName());
			ps.setString(2, st.getDateOfBirth());
			
			if(st.getSex().toLowerCase().equals("nam")) {
				ps.setInt(3, 1);
			}else if(st.getSex().toLowerCase().equals("nữ")){
				ps.setInt(3, 0);
			}else {
				ps.setInt(3, 1);
			}
			
			ps.setInt(4, st.getClasses().getID_Class());
			kq = ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return kq;
	}
	/*
	 * 
	 */
	public int EditStudent(Student st){
		int kq = 0;
		Connection con = new DataConnection().getcn();
		if(con == null) {
			return -1;
		}
		try {
			String query = "UPDATE STUDENT SET NAME = ?, DateOfBirth = ?, Sex = ?, ID_Class = ? "
					+ " where ID = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, st.getName());
			ps.setString(2, st.getDateOfBirth());
			
			if(st.getSex().toLowerCase().equals("nam")) {
				ps.setInt(3, 1);
			}else if(st.getSex().toLowerCase().equals("nữ")){
				ps.setInt(3, 0);
			}else {
				ps.setInt(3, 1);
			}
			ps.setInt(4, st.getClasses().getID_Class());
			ps.setInt(5, st.getID());
			kq = ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return kq;
	}
	/*
	 * 
	 */
	public int deleteStudent(int id){
		int kq = 0;
		Connection con = new DataConnection().getcn();
		if(con == null) {
			return -1;
		}
		try {
			String query = "DELETE Student where ID = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			kq = ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return kq;
	}
	
}
