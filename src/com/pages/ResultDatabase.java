package com.pages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultDatabase {
	String url="jdbc:mysql://localhost";
	String username="root";
	String password="";
	
	void result() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection(url,username,password);
			String query="CREATE DATABASE Result_Database";
			Statement statement=connection.createStatement();
			statement.execute(query);
			System.out.println("Result Databases Created");
			
			connection.close();
		}catch(ClassNotFoundException e) {
			System.out.println(e);
			
		}catch(SQLException ex) {
			System.out.println(ex);
			
			
		}
	}


	public static void main(String[] args) {
		ResultDatabase resultdatabase=new ResultDatabase();
		resultdatabase.result();


	}

}
