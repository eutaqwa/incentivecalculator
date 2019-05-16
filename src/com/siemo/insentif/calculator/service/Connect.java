package com.siemo.insentif.calculator.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
	private String myDriver  = "com.mysql.jdbc.Driver";
	private String myUrl = "jdbc:mysql://127.0.0.1:3306/incentivedatabase";
	private String username = "root";
	private String password = "cityofevil";
	private Connection conn = null;
	public Connection getConnected(){
		try {
			Class.forName(myDriver);
			conn = DriverManager.getConnection(myUrl, username, password);
		}catch(ClassNotFoundException cnfe){
			System.err.println("Class error= " + cnfe.getMessage() );
		}catch(SQLException se){
			System.err.println("SQL error= " + se.getMessage());
		}catch(Exception e){
			System.err.println("Error= " +e.getMessage());
		}return conn;
	}
}
