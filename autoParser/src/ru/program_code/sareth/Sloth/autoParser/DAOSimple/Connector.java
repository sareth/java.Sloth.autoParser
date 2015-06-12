package ru.program_code.sareth.Sloth.autoParser.DAOSimple;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_CONNECTION = "jdbc:mysql://srv-deb-tomcat.oat.local/Positions";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "fyukbz17";
	
	
	
	public static Connection getDBConnection() {
		 
		Connection dbConnection = null;
 
		try {
 
			Class.forName(DB_DRIVER);
 
		} catch (ClassNotFoundException e) {
 
			System.out.println(e.getMessage());
 
		}
 
		try {
 
			dbConnection = DriverManager.getConnection(
                             DB_CONNECTION, DB_USER,DB_PASSWORD);
			return dbConnection;
 
		} catch (SQLException e) {
 
			System.out.println(e.getMessage());
 
		}
 
		return dbConnection;
 
	}
 
}
