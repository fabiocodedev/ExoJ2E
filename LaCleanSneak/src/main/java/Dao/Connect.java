package Dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {
	public static Connection getConnect() {

		Connection myConnection = null;

		String url = "jdbc:mysql://localhost/";
		String dbName = "lacleansneak";
		String user = "root";
		String password = "";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			myConnection = DriverManager.getConnection(url+dbName,user,password);
			System.out.println("Connection OK !");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Pas de connection...");
		}
		return myConnection;
	}
}
