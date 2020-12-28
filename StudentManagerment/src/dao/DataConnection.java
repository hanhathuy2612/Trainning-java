package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataConnection {
	private String servername;
	private String port;
	private String db_name;
	private String db_user;
	private String db_pass;

	
	public DataConnection() {
		port = "1433";
		db_name = "Student";
		db_user = "huyhn";
		db_pass = "hanhathuy";
	}

	public Connection getcn() {
		Connection cn = null;
		try {
			String db_url = "jdbc:sqlserver://localhost:" + port + ";databaseName=" + db_name;
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			cn = DriverManager.getConnection(db_url, db_user, db_pass);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return cn;
	}

	public String test() {
		Connection cn = getcn();
		if (cn == null) {
			return "ket noi that bai";
		} else {
			return "ket noi thanh cong";
		}
	}

	public static void main(String[] args) {
		DataConnection m = new DataConnection();
		String me = m.test();
		System.out.println(me + " " + m.db_name);
	}
}
