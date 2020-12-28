package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import entities.Classes;
import entities.Student;

public class ClassesDAO implements Dao<Classes> {

	@Override
	public Optional<Classes> get(int id) {
		Classes classes = new Classes();
		Connection con = new DataConnection().getcn();
		if (con == null) {
			return null;
		}
		try {
			String query = "SELECT * FROM Class where id_Class = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int id_class = rs.getInt(1);
				String className = rs.getString(2);
				classes = new Classes(id_class, className);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Optional.of(classes);
	}

	@Override
	public Collection<Classes> getAll() {
		ArrayList<Classes> listClass = new ArrayList<Classes>();
		Connection con = new DataConnection().getcn();
		if (con == null) {
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
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listClass;
	}

	@Override
	public int save(Classes t) {
		int kq = 0;
		Connection con = new DataConnection().getcn();
		if (con == null) {
			return -1;
		}
		try {
			String query = "INSERT INTO dbo.Class VALUES (?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, t.getClassName());
			kq = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kq;
	}

	@Override
	public int update(Classes t) {
		int kq = 0;
		Connection con = new DataConnection().getcn();
		if (con == null) {
			return -1;
		}
		try {
			String query = "UPDATE CLASS set ClassName = ? where ID_Class = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, t.getClassName());
			ps.setInt(2, t.getID_Class());
			kq = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kq;
	}

	@Override
	public int delete(Classes t) {
		int kq = 0;
		Connection con = new DataConnection().getcn();
		if (con == null) {
			return -1;
		}
		try {
			String query = "EXEC DeleteClass ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, t.getID_Class());
			kq = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kq;
	}

}
