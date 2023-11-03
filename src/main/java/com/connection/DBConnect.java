package com.connection;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
private static Connection Conn =null;
	
	public static Connection getConn() {
		String url="jdbc:mysql://localhost:3306/bytes";
		String username="root";
		String password="2331";
		try
		{
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Conn = DriverManager.getConnection(url,username,password);
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
		
		return Conn;
	}

}
