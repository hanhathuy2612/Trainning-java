package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.Classes;
import entities.Student;

public class ClassesDAO {
	
	public ArrayList<Classes> getAllClass(){
		ArrayList<Classes> listClass = new ArrayList<Classes>();
		Connection con = new DataConnection().getcn();
		if(con == null) {
			return null;
		}
		try {
			String query = "SELECT * FROM Class";
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("ID_Class");
				String name = rs.getString("ClassName");
				Classes classes = new Classes(id, name);
				listClass.add(classes);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return listClass;
	}
	public int GetClassByID(int id) {
		int kq = 0;
		Connection con = new DataConnection().getcn();
		if(con == null) {
			return -1;
		}
		try {
			String query = "SELECT * FROM Class where id_Class = ?";
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
	public int AddClass(Classes classes){
		int kq = 0;
		Connection con = new DataConnection().getcn();
		if(con == null) {
			return -1;
		}
		try {
			String query = "INSERT INTO dbo.Class VALUES (?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, classes.getClassName());
			kq = ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return kq;
	}
	
	public int EditClass(Classes classes){
		int kq = 0;
		Connection con = new DataConnection().getcn();
		if(con == null) {
			return -1;
		}
		try {
			String query = "UPDATE CLASS set ClassName = ? where ID_Class = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, classes.getClassName());
			ps.setInt(2, classes.getID_Class());
			kq = ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return kq;
	}
	
	public int DeleteClass(int id){
		int kq = 0;
		Connection con = new DataConnection().getcn();
		if(con == null) {
			return -1;
		}
		try {
			String query = "EXEC DeleteClass ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			kq = ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return kq;
	}
	
}
